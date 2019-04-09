package fr.rekeningrijdersapplicatie.services;

import fr.rekeningrijdersapplicatie.pojos.Payment;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Set;
import fr.rekeningrijdersapplicatie.dao.interfaces.IPaymentDAO;
import fr.rekeningrijdersapplicatie.pojos.User;
import fr.rekeningrijdersapplicatie.qualifiers.PaymentDAOMock;
import java.util.Date;

@Stateless
public class PaymentService {

    @Inject
    @PaymentDAOMock
    private IPaymentDAO paymentDao;
    
    public PaymentService(IPaymentDAO paymentDao){
        this.paymentDao = paymentDao;
    }

    //verkrijg alle payments van iedere user.
    public Set<Payment> getPayments(Date date) {
        return paymentDao.getPayments(new Date());
    }

    //verkrijg alle payments van een user
    public Set<Payment> getPayments(User user) {
        return paymentDao.getPayments(user);
    }
    
    public void submitPayment(Payment payment){
        paymentDao.submitPayment(payment);
    }
}
