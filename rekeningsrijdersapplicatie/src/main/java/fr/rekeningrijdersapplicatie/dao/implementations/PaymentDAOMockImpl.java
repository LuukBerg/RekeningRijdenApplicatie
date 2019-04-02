package fr.rekeningrijdersapplicatie.dao.implementations;

import fr.rekeningrijdersapplicatie.pojos.Payment;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.Stateless;
import fr.rekeningrijdersapplicatie.dao.interfaces.IPaymentDAO;
import fr.rekeningrijdersapplicatie.enumerations.PaymentStatus;
import fr.rekeningrijdersapplicatie.pojos.User;
import fr.rekeningrijdersapplicatie.qualifiers.PaymentDAOMock;

@Stateless
@PaymentDAOMock
public class PaymentDAOMockImpl implements IPaymentDAO {

    private final Set<Payment> payments;

    public PaymentDAOMockImpl() {
        this.payments = new HashSet<Payment>();

        Payment unpaidPayment = new Payment();
        unpaidPayment.setId(1);
        unpaidPayment.setInvoiceUuid("asdasdqweqwe");
        unpaidPayment.setPaymentStatus(PaymentStatus.UNPAID);
        
        Payment paidPayment = new Payment();
        paidPayment.setId(2);
        paidPayment.setInvoiceUuid("iueyrewere");
        unpaidPayment.setPaymentStatus(PaymentStatus.PAID);

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

    @Override
    public Set<Payment> getPayments(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
