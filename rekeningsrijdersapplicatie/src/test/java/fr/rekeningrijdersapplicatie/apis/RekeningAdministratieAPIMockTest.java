package fr.rekeningrijdersapplicatie.apis;

import fr.rekeningrijdersapplicatie.pojos.Invoice;
import fr.rekeningrijdersapplicatie.pojos.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RekeningAdministratieAPIMockTest {

    private static User user1, user2, user3;
    private static List<Invoice> invoices;
    private static RekeningAdministratieAPIMock mock;

    @BeforeClass
    public static void setUp() {
        mock = new RekeningAdministratieAPIMock();
        invoices = new ArrayList<Invoice>();

        user1 = new User();
        user1.setId(1L);
        user1.setUuid("asdasdqweqwe");
        user1.setEmail("user1@mail1.net");
        user1.setUsername("user1_acc123");

        user2 = new User();
        user2.setId(5L);
        user2.setUuid("3rytrfdgdf");
        user2.setEmail("user2@mail.net");
        user2.setUsername("user2_acc123");

        user3 = new User();
        user3.setId(55L);
        user3.setUuid("tuyioupjdkfbs");
        user3.setEmail("user3@mail.net");
        user3.setUsername("user3_acc123");

        Invoice invoice = new Invoice();
    }

    @Test
    public void getUUID() {
//        String user1UUID = mock.getUUID(user1);
//        String user2UUID = mock.getUUID(user2);
//        String user3UUID = mock.getUUID(user3);
//
//        Assert.assertEquals(user1UUID, "asdasdqweqwe");
//        Assert.assertEquals(user2UUID, "3rytrfdgdf");
//        Assert.assertEquals(user3UUID, "tuyioupjdkfbs");
    }

    @Test
    public void getInvoices() {
        Set<Invoice>invoices = mock.getInvoices(user2);

        Assert.assertNotNull(invoices);
    }
}
