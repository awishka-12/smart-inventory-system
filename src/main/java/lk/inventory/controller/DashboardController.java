package lk.inventory.controller;

import lk.inventory.entity.Dashboard;
import lk.inventory.repository.CategoryRepository;
import lk.inventory.repository.ProductRepository;
import lk.inventory.repository.StockTransactionRepository;
import lk.inventory.repository.supplierRespository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final StockTransactionRepository stockTransactionRepository;
    private final supplierRespository supplierRespository;

    public DashboardController(CategoryRepository categoryRepository,
                               ProductRepository productRepository,
                               StockTransactionRepository stockTransactionRepository,
                               supplierRespository supplierRespository) {

        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.stockTransactionRepository = stockTransactionRepository;
        this.supplierRespository = supplierRespository;
    }

    @GetMapping("/api/dashboard")
    public Dashboard dashboard(){

        Dashboard dashboard = new Dashboard();
        dashboard.setTotalCattegories(this.categoryRepository.count());
        dashboard.setTotalProducts(this.productRepository.count());
        dashboard.setTotalSuppliers(this.supplierRespository.count());
        dashboard.setTotalTransactions(this.stockTransactionRepository.count());

        return dashboard;
    }
}
