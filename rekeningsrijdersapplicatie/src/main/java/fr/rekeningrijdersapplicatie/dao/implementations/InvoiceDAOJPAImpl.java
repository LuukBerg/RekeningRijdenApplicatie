package fr.rekeningrijdersapplicatie.dao.implementations;

import fr.rekeningrijdersapplicatie.dao.interfaces.IInvoiceDAO;
import fr.rekeningrijdersapplicatie.pojos.Invoice;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

@Stateless
@Default
public class InvoiceDAOJPAImpl implements IInvoiceDAO {

    @Override
    public List<Invoice> getPayments() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
