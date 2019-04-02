package fr.rekeningrijdersapplicatie.dao.implementations;

import fr.rekeningrijdersapplicatie.dao.interfaces.IInvoiceDAO;
import fr.rekeningrijdersapplicatie.pojos.Invoice;
import fr.rekeningrijdersapplicatie.qualifiers.InvoiceDAOMock;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
@InvoiceDAOMock
public class InvoiceDAOMockImpl implements IInvoiceDAO {

    @Override
    public List<Invoice> getPayments() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void submitPayment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
