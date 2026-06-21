package lk.inventoty.service;

import lk.inventoty.entity.Product;
import lk.inventoty.repository.ProductRepository;
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
