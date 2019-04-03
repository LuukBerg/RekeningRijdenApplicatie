package fr.rekeningrijdersapplicatie.services;

import fr.rekeningrijdersapplicatie.apis.IRekeningAdministratieAPI;
import fr.rekeningrijdersapplicatie.dao.interfaces.IPaymentDAO;
import fr.rekeningrijdersapplicatie.dao.interfaces.IUserDAO;
import fr.rekeningrijdersapplicatie.pojos.Invoice;
import fr.rekeningrijdersapplicatie.pojos.LoginInfo;
import fr.rekeningrijdersapplicatie.pojos.Payment;
import fr.rekeningrijdersapplicatie.pojos.RegistrationInfo;
import fr.rekeningrijdersapplicatie.pojos.User;
import fr.rekeningrijdersapplicatie.pojos.UserInfo;
import fr.rekeningrijdersapplicatie.qualifiers.PaymentDAOMock;
import fr.rekeningrijdersapplicatie.qualifiers.RekeningAdministratieMock;
import fr.rekeningrijdersapplicatie.qualifiers.UserDAOMock;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UserService {

    @Inject
    @UserDAOMock
    private IUserDAO userDao;
    
    @Inject
    @PaymentDAOMock
    private IPaymentDAO paymentDao;

    @Inject
    @RekeningAdministratieMock
    private IRekeningAdministratieAPI rekeningAdministratieAPI;
    
    public UserService(IUserDAO userDao, IRekeningAdministratieAPI rekeningAdministratieAPI){
        this.userDao = userDao;
        this.rekeningAdministratieAPI = rekeningAdministratieAPI;
    }

    public void register(RegistrationInfo registrationInfo){
        User user = userDao.register(registrationInfo);
        
        if(user == null)
            return; //throw exception
        
        UserInfo userInfo = rekeningAdministratieAPI.getUserInfo(user.getBsn());
        if(userInfo == null)
            return; //throw exception
        
        String uuid = userInfo.getUuid();
        if(uuid == null || uuid.equals(""))
            return; //throw exception
        
        user.setUuid(userInfo.getUuid());
        user.setEnabled(true);
        userDao.updateUser(user);
    }

    public User login(LoginInfo loginInfo){
        return userDao.login(loginInfo);
    }
    
    public Set<Invoice> getInvoices(User user){
        Set<Invoice> invoices = rekeningAdministratieAPI.getInvoices(user);
        Set<Payment> payments = paymentDao.getPayments(user);
        //TODO - Check only payments of last 24 hours against invoices of last 24 hours.
        return invoices;
    }
    
}
