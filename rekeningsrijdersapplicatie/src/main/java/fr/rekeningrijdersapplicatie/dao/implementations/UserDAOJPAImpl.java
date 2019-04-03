package fr.rekeningrijdersapplicatie.dao.implementations;

import fr.rekeningrijdersapplicatie.dao.interfaces.IUserDAO;
import fr.rekeningrijdersapplicatie.pojos.*;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Default
public class UserDAOJPAImpl implements IUserDAO {

    @PersistenceContext(unitName = "RekAppPU")
    private EntityManager entityManager;

    public UserDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User register(RegistrationInfo registrationInfo) {
        entityManager.getTransaction().begin();
        entityManager.persist(registrationInfo);
        entityManager.getTransaction().commit();
        
        return findByID(registrationInfo.getId());
    }

    @Override
    public User login(LoginInfo loginInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void updateUser(User user){
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public User findByID(long id) {
        return entityManager.find(User.class, id);
    }
}
