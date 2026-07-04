package lk.inventory.controller;

import jakarta.validation.Valid;
import lk.inventory.entity.Category;
import lk.inventory.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @PostMapping
    public Category save(@Valid @RequestBody Category category) {
        return service.save(category);
    }

    @GetMapping
    public List<Category> findAll() {
        return service.findAll();
    }
}
