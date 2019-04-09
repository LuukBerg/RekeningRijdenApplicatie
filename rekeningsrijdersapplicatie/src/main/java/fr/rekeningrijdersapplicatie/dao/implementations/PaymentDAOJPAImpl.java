package fr.rekeningrijdersapplicatie.dao.implementations;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import fr.rekeningrijdersapplicatie.dao.interfaces.IPaymentDAO;
import fr.rekeningrijdersapplicatie.pojos.Payment;
import fr.rekeningrijdersapplicatie.pojos.User;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Default
public class PaymentDAOJPAImpl implements IPaymentDAO {
    
    @PersistenceContext(unitName = "RekAppPU")
    private EntityManager entityManager;
    
    public PaymentDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }    

    @Override
    public Set<Payment> getPayments(Date date) {
//        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        Query query = entityManager.createQuery("SELECT p.id, p.invoiceUuid, p.paymentStatus FROM Payment p WHERE p.date = :date");
        query.setParameter("date", date);
        
        return getPayments(query);
    }

    @Override
    public void submitPayment(Payment payment) {
        entityManager.getTransaction().begin();
        entityManager.persist(payment);
        entityManager.getTransaction().commit();
    }

    @Override
    public Set<Payment> getPayments(User user) {
        Query query = entityManager.createQuery("SELECT p.id, p.invoiceUuid, p.userUuid, p.paymentStatus, p.date FROM Payment p WHERE p.userUuid = :userUuid ORDER BY p.date");
        query.setParameter("userUuid", user.getUuid());
        
        return getPayments(query);
    }
    
    private Set<Payment> getPayments(Query query){
        List resultList = query.getResultList();
        if(resultList.isEmpty())
            return null;
        else
            return new HashSet<Payment>(resultList);
    }
}
