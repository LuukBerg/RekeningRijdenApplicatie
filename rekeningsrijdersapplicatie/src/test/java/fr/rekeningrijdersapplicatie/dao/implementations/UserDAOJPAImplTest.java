/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rekeningrijdersapplicatie.dao.implementations;

import fr.rekeningrijdersapplicatie.pojos.LoginInfo;
import fr.rekeningrijdersapplicatie.pojos.RegistrationInfo;
import fr.rekeningrijdersapplicatie.pojos.User;
import fr.rekeningrijdersapplicatie.pojos.Vehicle;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ken
 */
public class UserDAOJPAImplTest {
    
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static UserDAOJPAImpl userService;

    @BeforeClass
    public static void setUp() {
        UserDAOJPAImplTest.entityManagerFactory = Persistence.createEntityManagerFactory("KwetterPUTest");
        UserDAOJPAImplTest.entityManager = entityManagerFactory.createEntityManager();
        UserDAOJPAImplTest.userService = new UserDAOJPAImpl(entityManager);
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
    public void testRegister() throws Exception {
        
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
