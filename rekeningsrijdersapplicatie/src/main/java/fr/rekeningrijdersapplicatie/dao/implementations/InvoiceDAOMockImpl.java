package fr.rekeningrijdersapplicatie.dao.implementations;

import fr.rekeningrijdersapplicatie.dao.interfaces.IInvoiceDAO;
import fr.rekeningrijdersapplicatie.qualifiers.InvoiceDAOMock;

import javax.ejb.Stateless;

@Stateless
@InvoiceDAOMock
public class InvoiceDAOMockImpl implements IInvoiceDAO {
}
