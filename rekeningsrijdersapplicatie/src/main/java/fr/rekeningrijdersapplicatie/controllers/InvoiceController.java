package fr.rekeningrijdersapplicatie.controllers;

import fr.rekeningrijdersapplicatie.pojos.Invoice;
import fr.rekeningrijdersapplicatie.services.InvoiceService;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ken
 */

//API voor rekeningadministratie
@Stateless
@Path("/invoice")
@Consumes(MediaType.APPLICATION_JSON)
public class InvoiceController {

    @Inject
    private InvoiceService invoiceService;
    
    public Set<Invoice> getInvoices(String uuid){
        return null;
    }
}
