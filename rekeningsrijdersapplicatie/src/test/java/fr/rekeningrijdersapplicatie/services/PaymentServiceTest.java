package fr.rekeningrijdersapplicatie.services;

import fr.rekeningrijdersapplicatie.apis.RekeningAdministratieAPIMock;
import fr.rekeningrijdersapplicatie.dao.implementations.PaymentDAOJPAImpl;
import fr.rekeningrijdersapplicatie.dao.implementations.PaymentDAOMockImpl;
import fr.rekeningrijdersapplicatie.dao.implementations.UserDAOJPAImpl;
import fr.rekeningrijdersapplicatie.enumerations.PaymentStatus;
import fr.rekeningrijdersapplicatie.pojos.Payment;
import fr.rekeningrijdersapplicatie.pojos.User;
import java.util.Date;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PaymentServiceTest {
    
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static UserService jpaUserService;

    private static PaymentService paymentService;

    @BeforeClass
    public static void setUp(){
        PaymentServiceTest.entityManagerFactory = Persistence.createEntityManagerFactory("RekAppPUTest");
        PaymentServiceTest.entityManager = entityManagerFactory.createEntityManager();
        PaymentServiceTest.jpaUserService = new UserService(new UserDAOJPAImpl(entityManager), new RekeningAdministratieAPIMock());
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
    public void getPayments() {
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
        assertEquals(1, payments.size());
    }

    @Test
    public void submitPayment() {
        Payment payment = new Payment();
        payment.setDate(new Date());
        payment.setInvoiceUuid("qwdlwijfm");
        payment.setUserUuid("1");
        payment.setPaymentStatus(PaymentStatus.UNPAID);

        paymentService.submitPayment(payment);

        assertEquals(1, paymentService.getPayments(new Date()).size());
    }
    
}
