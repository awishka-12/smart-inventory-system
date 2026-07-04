package lk.inventory.service;

import lk.inventory.entity.Product;
import lk.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product save(Product product) {
        return repo.save(product);
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product getById(long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

    public Product update(long id, Product product) {

        Product existing = repo.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setQuantity(product.getQuantity());

            return repo.save(existing);
        }

        return null;
    }
}
