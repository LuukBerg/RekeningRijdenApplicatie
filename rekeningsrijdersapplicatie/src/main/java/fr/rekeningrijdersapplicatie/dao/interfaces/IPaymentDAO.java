package fr.rekeningrijdersapplicatie.dao.interfaces;

import fr.rekeningrijdersapplicatie.pojos.Payment;
import fr.rekeningrijdersapplicatie.pojos.User;

import java.util.Set;

public interface IPaymentDAO {

    Set<Payment> getPayments();
    
    Set<Payment> getPayments(User user);

    void submitPayment(Payment payment);
}
