package fr.rekeningrijdersapplicatie.dao.interfaces;

import fr.rekeningrijdersapplicatie.pojos.Payment;

import java.util.Set;

public interface IPaymentDAO {

    Set<Payment> getPayments();

    void submitPayment(Payment payment);
}
