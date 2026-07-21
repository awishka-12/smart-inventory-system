package lk.inventory.controller;

import jakarta.validation.Valid;
import lk.inventory.dto.ProductRequest;
import lk.inventory.dto.ProductResponse;
import lk.inventory.entity.Product;
import lk.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<ProductResponse> saveProduct(@Valid @RequestBody ProductRequest productRequest) {
        ProductResponse response=service.save(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<ProductResponse> getProductById(@RequestParam long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(service.update(id, productRequest));
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteProductById(@RequestParam long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
