package lk.inventory.service;

import lk.inventory.dto.ProductRequest;
import lk.inventory.dto.ProductResponse;
import lk.inventory.entity.Category;
import lk.inventory.entity.Product;
import lk.inventory.exception.ResourceNotFoundException;
import lk.inventory.repository.CategoryRepository;
import lk.inventory.repository.ProductRepository;
import org.hibernate.query.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private static final Logger logger =
            LoggerFactory.getLogger(AuthService.class);


    private final ProductRepository productRepository;
    public final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductResponse save(ProductRequest productRequest) {
        Category category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found" )
                );
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        product.setCategory(category);

        logger.info("Creating Product : {}", product.getName());

        Product savedProduct = productRepository.save(product);
        return new ProductResponse(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getPrice(),
                savedProduct.getQuantity(),
                savedProduct.getCategory().getName()

        );

    }

    public ProductResponse findById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found" ));

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getCategory().getName()
        );
    }

    public List<ProductResponse> findAll() {

        return productRepository.findAll().
                stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getQuantity(),
                        product.getCategory().getName()
                ))
                .toList();
    }

    public ProductResponse update(Long id, ProductRequest productRequest) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found" ));

        Category category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found" )
                );
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setQuantity(productRequest.getQuantity());
        product.setCategory(category);

        Product updatedProduct = productRepository.save(product);
        logger.info("Updating Product : {}", id);

        return new ProductResponse(
                updatedProduct.getId(),
                updatedProduct.getName(),
                updatedProduct.getPrice(),
                updatedProduct.getQuantity(),
                updatedProduct.getCategory().getName()
        );

    }

    public void deleteById(Long id) {
        Product product= productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Product not found" ));

        productRepository.delete(product);
        logger.info("Product Deleted : {}", id);
    }

    public List<ProductResponse> searchByName(String name) {

        return productRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getQuantity(),
                        product.getCategory().getName()
                ))
                .toList();
    }


}