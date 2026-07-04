package lk.inventory.repository;

import lk.inventory.entity.StockTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockTransactionRepository extends JpaRepository<StockTransaction,Integer> {
}
