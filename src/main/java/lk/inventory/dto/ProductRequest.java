package lk.inventory.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductRequest {


    @NotBlank(message = "Product name is required")
    private String name;

    @Min(value = 1, message = "Price must be greater than 0")
    private double price;

    @Min(value = 1, message = "Quantity must be greater than 0")
    private int quantity;

    @NotNull(message = "Category is required")
    private Long categoryId;

    public ProductRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
