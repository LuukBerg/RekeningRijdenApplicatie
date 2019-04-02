/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.rekeningrijdersapplicatie.apis;

import fr.rekeningrijdersapplicatie.pojos.Invoice;
import fr.rekeningrijdersapplicatie.pojos.User;
import fr.rekeningrijdersapplicatie.qualifiers.RekeningAdministratieMock;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.ejb.Stateless;

@Stateless
@RekeningAdministratieMock
public class RekeningAdministratieAPIMock implements IRekeningAdministratieAPI {
    
    private final Map<Long, String> uuidMap;
    private final Map<String, Set<Invoice>> invoiceMap;
    
    public RekeningAdministratieAPIMock(){
        this.uuidMap = new HashMap<Long, String>();        
        this.uuidMap.put(1L, "asdasdqweqwe");
        this.uuidMap.put(5L, "3rytrfdgdf");
        this.uuidMap.put(55L, "tuyioupjdkfbs");
        
        this.invoiceMap = new HashMap<String, Set<Invoice>>();
        Set<Invoice> invoices = new HashSet<Invoice>();
        Invoice invoice = new Invoice();
        invoice.setId(5);
        invoice.setUuid("3rytrfdgdf");
        invoices.add(invoice);
        this.invoiceMap.put(invoice.getUuid(), invoices);
    }

    @Override
    public String getUUID(User user) {
        long userId = user.getId();
        return uuidMap.get(userId);
    }

    @Override
    public Set<Invoice> getInvoices(User user) {
        return invoiceMap.get(user.getUuid());
    }
    
}
