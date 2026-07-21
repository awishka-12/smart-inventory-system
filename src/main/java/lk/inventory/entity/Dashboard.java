package lk.inventory.entity;

import jakarta.persistence.Entity;
import lombok.Data;


@Data
public class Dashboard {
    private Long totalProducts;
    private Long totalSuppliers;
    private Long totalTransactions;
    private Long totalCattegories;

    public Long getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Long totalProducts) {
        this.totalProducts = totalProducts;
    }

    public Long getTotalSuppliers() {
        return totalSuppliers;
    }

    public void setTotalSuppliers(Long totalSuppliers) {
        this.totalSuppliers = totalSuppliers;
    }

    public Long getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(Long totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public Long getTotalCattegories() {
        return totalCattegories;
    }

    public void setTotalCattegories(Long totalCattegories) {
        this.totalCattegories = totalCattegories;
    }
}
