package fr.rekeningrijdersapplicatie.controllers;

import fr.rekeningrijdersapplicatie.pojos.Payment;
import fr.rekeningrijdersapplicatie.services.PaymentService;
import java.util.Date;
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
public class PaymentController {

    @Inject
    private PaymentService paymentService;
    
    public Set<Payment> getPayments(Date date){
        return paymentService.getPayments();
    }
    
}
