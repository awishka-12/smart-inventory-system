package lk.inventory.service;

import lk.inventory.entity.Category;
import lk.inventory.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public Category save(Category category) {

        return repo.save(category);
    }

    public List<Category> findAll() {
        return repo.findAll();
    }
}
