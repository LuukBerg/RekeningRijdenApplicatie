package fr.rekeningrijdersapplicatie.dao.implementations;

import fr.rekeningrijdersapplicatie.enumerations.PaymentStatus;
import fr.rekeningrijdersapplicatie.pojos.Payment;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateless;
import fr.rekeningrijdersapplicatie.dao.interfaces.IPaymentDAO;
import fr.rekeningrijdersapplicatie.qualifiers.PaymentDAOMock;

@Stateless
@PaymentDAOMock
public class PaymentDAOMockImpl implements IPaymentDAO {
    
    private final Set<Payment> payments;
    
    public PaymentDAOMockImpl(){
        this.payments = new HashSet<Payment>();

        Payment unpaidPayment = new Payment();
        unpaidPayment.setId(1);
        unpaidPayment.setInvoiceUuid("asdasdqweqwe");

        Payment paidPayment = new Payment();
        paidPayment.setId(2);
        paidPayment.setInvoiceUuid("iueyrewere");

        payments.add(unpaidPayment);
        payments.add(paidPayment);
    }

    @Override
    public Set<Payment> getPayments() {
        return this.payments;
    }

    @Override
    public void submitPayment(Payment payment) {
        this.payments.add(payment);
    }
}
