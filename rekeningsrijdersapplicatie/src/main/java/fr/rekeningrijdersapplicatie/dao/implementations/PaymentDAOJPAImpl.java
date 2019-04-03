package fr.rekeningrijdersapplicatie.dao.implementations;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import fr.rekeningrijdersapplicatie.dao.interfaces.IPaymentDAO;
import fr.rekeningrijdersapplicatie.pojos.Payment;
import fr.rekeningrijdersapplicatie.pojos.User;
import java.util.Date;
import java.util.Set;

@Stateless
@Default
public class PaymentDAOJPAImpl implements IPaymentDAO {

    @Override
    public Set<Payment> getPayments(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void submitPayment(Payment payment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Payment> getPayments(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
