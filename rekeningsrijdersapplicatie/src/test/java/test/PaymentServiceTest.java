package test;

import fr.rekeningrijdersapplicatie.dao.implementations.PaymentDAOMockImpl;
import fr.rekeningrijdersapplicatie.pojos.Payment;
import fr.rekeningrijdersapplicatie.services.PaymentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class PaymentServiceTest {

    private PaymentService paymentService;

    @Before
    public void setUp(){
        paymentService = new PaymentService(new PaymentDAOMockImpl());
    }

    @Test
    public void getPayments() {
        Assert.assertNotNull(paymentService.getPayments());
        Assert.assertEquals(2, paymentService.getPayments().size());

        Iterator<Payment> iterator = paymentService.getPayments().iterator();

        Payment payment1 = iterator.next();

        Assert.assertEquals(2, payment1.getId());

        Payment payment2 = iterator.next();

        Assert.assertEquals(1, payment2.getId());
    }

    @Test
    public void submitPayment() {
        Payment payment = new Payment();
        payment.setId(3);
        payment.setInvoiceUuid("qwdlwijfm");

        Assert.assertEquals(2, paymentService.getPayments().size());

        paymentService.submitPayment(payment);

        Assert.assertEquals(3, paymentService.getPayments().size());
    }
}
