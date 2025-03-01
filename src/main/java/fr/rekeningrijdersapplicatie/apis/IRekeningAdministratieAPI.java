/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rekeningrijdersapplicatie.apis;

import fr.rekeningrijdersapplicatie.pojos.Invoice;
import fr.rekeningrijdersapplicatie.pojos.User;
import fr.rekeningrijdersapplicatie.pojos.UserInfo;
import fr.rekeningrijdersapplicatie.pojos.Vehicle;
import java.util.Set;

/**
 *
 * @author Ken
 */
public interface IRekeningAdministratieAPI {
    
    UserInfo getUserInfo(String bsn);
    
    Set<Invoice> getInvoices(User user);
    
    Set<Vehicle> getVehicles(User user);
}
