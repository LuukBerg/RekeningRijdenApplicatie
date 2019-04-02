package fr.rekeningrijdersapplicatie.dao.interfaces;

import fr.rekeningrijdersapplicatie.pojos.Invoice;

import java.util.List;

public interface IInvoiceDAO {
    List<Invoice> getInvoices();
}
