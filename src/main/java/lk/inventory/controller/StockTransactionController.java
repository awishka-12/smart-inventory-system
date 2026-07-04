package lk.inventory.controller;

import lk.inventory.entity.StockTransaction;
import lk.inventory.service.StockTransactionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock")
public class StockTransactionController {

    private final StockTransactionService service;

    public StockTransactionController(StockTransactionService service) {
        this.service = service;
    }

        @PostMapping
    public StockTransaction save(@RequestBody StockTransaction stockTransaction) {
        return service.save(stockTransaction);
        }
}
