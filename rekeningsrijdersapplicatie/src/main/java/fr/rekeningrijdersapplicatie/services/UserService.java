package fr.rekeningrijdersapplicatie.services;

import fr.rekeningrijdersapplicatie.apis.IRekeningAdministratieAPI;
import fr.rekeningrijdersapplicatie.dao.interfaces.IUserDAO;
import fr.rekeningrijdersapplicatie.pojos.Invoice;
import fr.rekeningrijdersapplicatie.pojos.LoginInfo;
import fr.rekeningrijdersapplicatie.pojos.RegistrationInfo;
import fr.rekeningrijdersapplicatie.pojos.User;
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
    @RekeningAdministratieMock
    private IRekeningAdministratieAPI rekeningAdministratieAPI;
    
    public UserService(IUserDAO userDao, IRekeningAdministratieAPI rekeningAdministratieAPI){
        this.userDao = userDao;
        this.rekeningAdministratieAPI = rekeningAdministratieAPI;
    }

    public User register(RegistrationInfo registrationInfo){
        return userDao.register(registrationInfo);
    }

    public User login(LoginInfo loginInfo){
        return userDao.login(loginInfo);
    }
    
    public Set<Invoice> getInvoices(User user){
        return rekeningAdministratieAPI.getInvoices(user);
    }
    
}
