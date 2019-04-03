package fr.rekeningrijdersapplicatie.dao.implementations;

import fr.rekeningrijdersapplicatie.dao.interfaces.IUserDAO;
import fr.rekeningrijdersapplicatie.pojos.*;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        Query query = entityManager.createNativeQuery("SELECT u.id, u.email, u.username, u.uuid, u.enabled FROM rekapp_user u WHERE u.username = :username AND u.password = :password");
        //Query query = entityManager.createQuery("SELECT u.id, u.email, u.username, u.uuid, u.enabled FROM userlogindaoobj u WHERE u.username = :username AND u.password = :password");
        query.setParameter("username", loginInfo.getUsername());
        query.setParameter("password", loginInfo.getPassword());
        
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//        Root<User> root = criteriaQuery.from(User.class);
//        criteriaQuery.select(root);
//
//        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
//
//        ParameterExpression<String> username = criteriaBuilder.parameter(String.class);
//        criteriaQuery.where(criteriaBuilder.equal(root.get("username"), username));
//        
////        ParameterExpression<String> password = criteriaBuilder.parameter(String.class);
////        criteriaQuery.where(criteriaBuilder.equal(root.get("password"), password));
//        
//        query.setParameter(username, loginInfo.getUsername());
////        query.setParameter(password, loginInfo.getPassword());

        List resultList = query.getResultList();
        Iterator iterator = resultList.iterator();

        if (iterator.hasNext()) {
            try {
                Object[] obj = (Object[]) iterator.next();
                long id = ((Number) obj[0]).longValue();
                String email = (String) obj[1];
                String username = (String) obj[2];
                String uuid = (String) obj[3];
                boolean enabled = ((Boolean) obj[4]);

                User user = new User();
                user.setId(id);
                user.setEmail(email);
                user.setUsername(username);
                user.setUuid(uuid);
                user.setEnabled(enabled);
                return user;
            } catch (Exception ex) {
                Logger.getLogger(UserDAOJPAImpl.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        } else {
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
