package fr.rekeningrijdersapplicatie.services;

import fr.rekeningrijdersapplicatie.pojos.Payment;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Set;
import fr.rekeningrijdersapplicatie.dao.interfaces.IPaymentDAO;
import fr.rekeningrijdersapplicatie.qualifiers.PaymentDAOMock;

@Stateless
public class PaymentService {

    @Inject
    @PaymentDAOMock
    private IPaymentDAO paymentDao;
    
    public PaymentService(IPaymentDAO paymentDao){
        this.paymentDao = paymentDao;
    }

    //verkrijg alle payments van iedere user.
    public Set<Payment> getPayments() {
        return paymentDao.getPayments();
    }

    public void submitPayment(Payment payment) {
        paymentDao.submitPayment(payment);
    }
}
