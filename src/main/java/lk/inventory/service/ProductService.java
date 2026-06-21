package lk.inventory.service;

import lk.inventory.entity.Product;
import lk.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public Product save(Product product){
        return repo.save(product);
    }

    public List<Product> getAll(){
        return repo.findAll();
    }
}
