package fr.rekeningrijdersapplicatie.pojos;

import fr.rekeningrijdersapplicatie.enumerations.PaymentStatus;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Payment implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(nullable = false, unique = true)
    private String invoiceUuid;
    
    @Enumerated(EnumType.STRING)
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
