package fr.rekeningrijdersapplicatie.dao.implementations;

import fr.rekeningrijdersapplicatie.dao.interfaces.IUserDAO;
import fr.rekeningrijdersapplicatie.pojos.*;
import java.util.Set;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Default
public class UserDAOJPAImpl implements IUserDAO {
    
    @PersistenceContext(unitName ="RekAppPUTest")
    private EntityManager entityManager;
    
    public UserDAOJPAImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public User register(RegistrationInfo registrationInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User login(LoginInfo loginInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Vehicle> getVehicles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserInfo getUserInfo() {
        return null;
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        
    }
    
    @Override
    public User findByID(int id){
        return null;
    }
}
