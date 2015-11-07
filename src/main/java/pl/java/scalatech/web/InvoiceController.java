package pl.java.scalatech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.java.scalatech.domain.Invoice;
import pl.java.scalatech.repository.InvoiceRepository;
import pl.java.scalatech.service.invoice.InvoiceService;

@RestController

@RequiredArgsConstructor(onConstructor = @__(@Autowired) )
@RequestMapping(InvoiceController.URL)
public class InvoiceController extends AbstractRestController<Invoice>{
    protected static final String URL = "/invoices";
    private final @NonNull InvoiceService invoiceService;
    private final @NonNull InvoiceRepository invoiceRepository;

    @RequestMapping("/name/{name}")
    public ResponseEntity<Invoice> findByName(@PathVariable("name") String name) {
        Invoice loaded = invoiceRepository.findByName(name).orElseThrow(() -> new IllegalArgumentException("id not exists"));
        return ResponseEntity.ok(loaded);
    }

    @Override
    protected String getURL() {
        return URL;
    }


}
