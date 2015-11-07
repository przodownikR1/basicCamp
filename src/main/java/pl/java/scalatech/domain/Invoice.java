package pl.java.scalatech.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

@Entity
public class Invoice extends AbstractEntity{


   /* @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "id")
    private User issuingAnInvoice;
    @OneToOne
    private User recipientOfInvoice;
    */
    private String name;
    @OneToMany
    private List<Product> products;
    private boolean paid;
    private Date dateOfInvoice;
    @Enumerated
    private InvoiceType invoiceType;

}
