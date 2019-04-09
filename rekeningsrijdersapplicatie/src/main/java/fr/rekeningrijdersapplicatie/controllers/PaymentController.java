package fr.rekeningrijdersapplicatie.controllers;

import fr.rekeningrijdersapplicatie.pojos.Payment;
import fr.rekeningrijdersapplicatie.pojos.User;
import fr.rekeningrijdersapplicatie.services.PaymentService;
import java.util.Date;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ken
 */

//API voor rekeningadministratie
@Stateless
@Path("/payments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PaymentController {

    @Inject
    private PaymentService paymentService;
    
    public Set<Payment> getPayments(Date date){
        return paymentService.getPayments(date);
    }
    
    public Set<Payment> getPayments(User user){
        return paymentService.getPayments(user);
    }
    
}
