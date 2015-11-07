package pl.java.scalatech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.java.scalatech.domain.Product;
import pl.java.scalatech.repository.ProductRepository;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired) )
@RequestMapping(ProductContoller.URL)
public class ProductContoller extends AbstractRestController<Product> {
    protected static final String URL = "/products";
    private final @NonNull ProductRepository productRepository;

    @RequestMapping("/name/{name}")
    public ResponseEntity<Product> findByName(@PathVariable("name") String name) {
        Product loaded = productRepository.findByName(name).orElseThrow(() -> new IllegalArgumentException("id not exists"));
        return ResponseEntity.ok(loaded);
    }

    @Override
    protected String getURL() {
        return URL;
    }

}
