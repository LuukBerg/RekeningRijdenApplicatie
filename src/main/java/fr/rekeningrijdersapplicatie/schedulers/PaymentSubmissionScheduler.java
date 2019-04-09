/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rekeningrijdersapplicatie.schedulers;

import fr.rekeningrijdersapplicatie.dao.interfaces.IPaymentDAO;
import fr.rekeningrijdersapplicatie.pojos.Payment;
import fr.rekeningrijdersapplicatie.qualifiers.PaymentDAOMock;
import java.sql.Date;
import java.util.Set;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;

/**
 *
 * @author Ken
 */
@Singleton
public class PaymentSubmissionScheduler {
    
    @Inject
    @PaymentDAOMock
    private IPaymentDAO paymentDao;
    
    @Schedule(hour = "24", persistent = true)
    public void sendPayments(){
        //Set<Payment> payments = paymentDao.getPayments(new Date);
        //TODO - Send payments.
    }
}
