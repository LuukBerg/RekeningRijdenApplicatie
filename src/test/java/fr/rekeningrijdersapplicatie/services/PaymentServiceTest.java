package fr.rekeningrijdersapplicatie.services;

import fr.rekeningrijdersapplicatie.dao.implementations.PaymentDAOJPAImpl;
import fr.rekeningrijdersapplicatie.enumerations.PaymentStatus;
import fr.rekeningrijdersapplicatie.pojos.Payment;
import fr.rekeningrijdersapplicatie.pojos.User;
import java.util.Date;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.BeforeClass;
import org.junit.Test;

public class PaymentServiceTest {
    
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static PaymentService paymentService;

    @BeforeClass
    public static void setUp(){
        PaymentServiceTest.entityManagerFactory = Persistence.createEntityManagerFactory("RekAppPUTest");
        PaymentServiceTest.entityManager = entityManagerFactory.createEntityManager();
        PaymentServiceTest.paymentService = new PaymentService(new PaymentDAOJPAImpl(entityManager));
    }

    @AfterClass
    public static void tearDown() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    @Test
    public void testSubmitAndGet() {
        User user = new User();
        user.setUuid("1");
        
        Payment payment = new Payment();
        payment.setDate(new Date());
        payment.setInvoiceUuid("qwdlwijfm");
        payment.setUserUuid(user.getUuid());
        payment.setPaymentStatus(PaymentStatus.UNPAID);
        
        paymentService.submitPayment(payment);
        
        Set<Payment> payments = paymentService.getPayments(user);
        assertNotNull(payments);
        
        Payment payment2 = payments.iterator().next();
        assertEquals(payment.getInvoiceUuid(), payment2.getInvoiceUuid());
    }
    
}
