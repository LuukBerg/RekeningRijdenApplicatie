package fr.rekeningrijdersapplicatie.pojos;

import fr.rekeningrijdersapplicatie.enumerations.PaymentStatus;

public class Payment {
    private long id;
    private String invoiceUuid;
    private PaymentStatus paymentStatus;

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

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
