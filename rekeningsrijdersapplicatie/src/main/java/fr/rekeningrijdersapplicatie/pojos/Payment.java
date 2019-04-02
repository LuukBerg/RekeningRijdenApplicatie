package fr.rekeningrijdersapplicatie.pojos;

import fr.rekeningrijdersapplicatie.enumerations.PaymentStatus;

public class Payment {
    private long id;
    private String invoiceUuid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInvoiceUuid() {
        return invoiceUuid;
    }

    public void setInvoiceUuid(String invoiceUuid) {
        this.invoiceUuid = invoiceUuid;
    }
    
}
