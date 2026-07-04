package lk.inventory.service;

import lk.inventory.entity.Product;
import lk.inventory.entity.StockTransaction;
import lk.inventory.repository.ProductRepository;
import lk.inventory.repository.StockTransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StockTransactionService {

    private final StockTransactionRepository stockRepo;
    private final ProductRepository productRepo;

    public StockTransactionService(
            StockTransactionRepository stockRepo,
            ProductRepository productRepo) {

        this.stockRepo = stockRepo;
        this.productRepo = productRepo;
    }

    public StockTransaction save(StockTransaction transaction) {

        Product product =
                productRepo.findById(
                                transaction.getProduct().getId())
                        .orElseThrow();

        if(transaction.getType().equalsIgnoreCase("IN")) {

            product.setQuantity(
                    product.getQuantity()
                            + transaction.getQuantity());

        } else if(transaction.getType().equalsIgnoreCase("OUT")) {

            if(product.getQuantity() < transaction.getQuantity()) {
                throw new RuntimeException(
                        "Insufficient Stock");
            }

            product.setQuantity(
                    product.getQuantity()
                            - transaction.getQuantity());
        }

        productRepo.save(product);

        transaction.setDate(LocalDateTime.now());

        return stockRepo.save(transaction);
    }
}
