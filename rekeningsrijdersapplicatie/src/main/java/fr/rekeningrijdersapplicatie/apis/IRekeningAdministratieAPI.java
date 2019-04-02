/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rekeningrijdersapplicatie.apis;

import fr.rekeningrijdersapplicatie.pojos.Invoice;
import fr.rekeningrijdersapplicatie.pojos.User;
import java.util.Set;

/**
 *
 * @author Ken
 */
public interface IRekeningAdministratieAPI {
    
    Set<Invoice> getInvoices(User user);
}
