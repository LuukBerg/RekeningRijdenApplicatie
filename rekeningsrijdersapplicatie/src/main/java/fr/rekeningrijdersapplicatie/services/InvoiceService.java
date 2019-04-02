package fr.rekeningrijdersapplicatie.services;

import fr.rekeningrijdersapplicatie.apis.IRekeningAdministratieAPI;
import fr.rekeningrijdersapplicatie.dao.interfaces.IInvoiceDAO;
import fr.rekeningrijdersapplicatie.pojos.Invoice;
import fr.rekeningrijdersapplicatie.pojos.Payment;
import fr.rekeningrijdersapplicatie.pojos.User;
import fr.rekeningrijdersapplicatie.qualifiers.InvoiceDAOMock;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Date;
import java.util.Set;

@Stateless
public class InvoiceService {

    @Inject
    @InvoiceDAOMock
    private IInvoiceDAO invoiceDao;

    //verkrijg alle payments van iedere user.
    public Set<Payment> getPayments(Date date) {
        return null;
    }

    public void submitPayment(Payment payment) {

    }
}
