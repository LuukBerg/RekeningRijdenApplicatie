package fr.rekeningrijdersapplicatie.services;

import fr.rekeningrijdersapplicatie.dao.implementations.PaymentDAOMockImpl;
import fr.rekeningrijdersapplicatie.pojos.Payment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
