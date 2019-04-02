package test;

import fr.rekeningrijdersapplicatie.dao.implementations.PaymentDAOMockImpl;
import fr.rekeningrijdersapplicatie.pojos.Payment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;
import java.util.Set;

public class PaymentDAOMockImplTest {

    private PaymentDAOMockImpl paymentDAO;

    @Before
    public void setUp(){
        paymentDAO = new PaymentDAOMockImpl();
    }

    @Test
    public void getPayments() {
        Assert.assertNotNull(paymentDAO.getPayments());
        Assert.assertEquals(paymentDAO.getPayments().size(), 2);

        Iterator<Payment> iterator = paymentDAO.getPayments().iterator();

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

        Assert.assertEquals(paymentDAO.getPayments().size(), 2);

        paymentDAO.submitPayment(payment);

        Assert.assertEquals(paymentDAO.getPayments().size(), 3);
    }
}
