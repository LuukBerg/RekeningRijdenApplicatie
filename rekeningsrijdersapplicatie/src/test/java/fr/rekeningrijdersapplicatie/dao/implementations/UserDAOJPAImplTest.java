/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rekeningrijdersapplicatie.dao.implementations;

//import fr.rekeningrijdersapplicatie.pojos.RegistrationInfo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.rekeningrijdersapplicatie.pojos.RegistrationInfo;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ken
 */
public class UserDAOJPAImplTest {
    
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static UserDAOJPAImpl userDao;

    @BeforeClass
    public static void setUp() {
        UserDAOJPAImplTest.entityManagerFactory = Persistence.createEntityManagerFactory("RekAppPUTest");
        UserDAOJPAImplTest.entityManager = entityManagerFactory.createEntityManager();
        UserDAOJPAImplTest.userDao = new UserDAOJPAImpl(entityManager);
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

    /**
     * Test of register method, of class UserDAOJPAImpl.
     */
    @Test
    public void testRegister() {
        RegistrationInfo registrationInfo = new RegistrationInfo();
        registrationInfo.setUsername("jan1234");
        registrationInfo.setPassword("wachtw00rd");
        registrationInfo.setEmail("jan123@hotmail.com");

        entityManager.getTransaction().begin();
        entityManager.persist(registrationInfo);
        entityManager.getTransaction().commit();
    }

    /**
     * Test of login method, of class UserDAOJPAImpl.
     */
    @Test
    public void testLogin() throws Exception {
        
    }

    /**
     * Test of getVehicles method, of class UserDAOJPAImpl.
     */
    @Test
    public void testGetVehicles() throws Exception {
        
    }

    /**
     * Test of findByID method, of class UserDAOJPAImpl.
     */
    @Test
    public void testFindByID() throws Exception {
        
    }
    
}
