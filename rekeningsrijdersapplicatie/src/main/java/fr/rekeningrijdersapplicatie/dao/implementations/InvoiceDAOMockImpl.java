package fr.rekeningrijdersapplicatie.dao.implementations;

import fr.rekeningrijdersapplicatie.dao.interfaces.IInvoiceDAO;
import fr.rekeningrijdersapplicatie.pojos.Invoice;
import fr.rekeningrijdersapplicatie.pojos.Payment;
import fr.rekeningrijdersapplicatie.qualifiers.InvoiceDAOMock;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;

@Stateless
@InvoiceDAOMock
public class InvoiceDAOMockImpl implements IInvoiceDAO {
    
    private final Set<Payment> payments;
    
    public InvoiceDAOMockImpl(){
        this.payments = new HashSet<Payment>();
    }

    @Override
    public List<Invoice> getPayments() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void submitPayment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
