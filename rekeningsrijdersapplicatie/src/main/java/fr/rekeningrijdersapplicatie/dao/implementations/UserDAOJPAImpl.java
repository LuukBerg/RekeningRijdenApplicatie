package fr.rekeningrijdersapplicatie.dao.implementations;

import fr.rekeningrijdersapplicatie.dao.interfaces.IUserDAO;
import fr.rekeningrijdersapplicatie.pojos.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

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
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        criteriaQuery.select(root);

        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);

        ParameterExpression<String> username = criteriaBuilder.parameter(String.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("username"), username));
        
//        ParameterExpression<String> password = criteriaBuilder.parameter(String.class);
//        criteriaQuery.where(criteriaBuilder.equal(root.get("password"), password));
        
        query.setParameter(username, loginInfo.getUsername());
//        query.setParameter(password, loginInfo.getPassword());

        try {
            return query.getSingleResult();
        } catch (Exception ex) {
            Logger.getLogger(UserDAOJPAImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void updateUser(User user) {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public User findByID(long id) {
        return entityManager.find(User.class, id);
    }
}
