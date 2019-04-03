package fr.rekeningrijdersapplicatie.services;

import fr.rekeningrijdersapplicatie.apis.RekeningAdministratieAPIMock;
import fr.rekeningrijdersapplicatie.dao.implementations.UserDAOJPAImpl;
import fr.rekeningrijdersapplicatie.dao.implementations.UserDAOMockImpl;
import fr.rekeningrijdersapplicatie.pojos.LoginInfo;
import fr.rekeningrijdersapplicatie.pojos.RegistrationInfo;
import fr.rekeningrijdersapplicatie.pojos.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserServiceTest {

    //private static UserService mockUserService;
    private static RegistrationInfo registerInfo;
    private static LoginInfo loginInfo;
    
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static UserService jpaUserService;

    @AfterClass
    public static void tearDown() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    @BeforeClass
    public static void setUp() {
        UserServiceTest.entityManagerFactory = Persistence.createEntityManagerFactory("RekAppPUTest");
        UserServiceTest.entityManager = entityManagerFactory.createEntityManager();
        UserServiceTest.jpaUserService = new UserService(new UserDAOJPAImpl(entityManager), new RekeningAdministratieAPIMock());
        
        //mockUserService = new UserService(new UserDAOMockImpl(), new RekeningAdministratieAPIMock());
        
        registerInfo = new RegistrationInfo();
        registerInfo.setEmail("user@test.com");
        registerInfo.setUsername("User_343");
        registerInfo.setPassword("Fsjksdi332");
        registerInfo.setBsn("testbsn");

        loginInfo = new LoginInfo();
        loginInfo.setUsername(registerInfo.getUsername());
        loginInfo.setPassword(registerInfo.getPassword());
    }

    @Test
    public void jpaRegister() {
        jpaUserService.register(registerInfo);

        User user = jpaUserService.login(loginInfo);
        
        assertNotNull(user);

        assertEquals(user.getEmail(), registerInfo.getEmail());
        assertEquals(user.getUsername(), registerInfo.getUsername());
    }
}
