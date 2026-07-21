package lk.inventory.controller;

import jakarta.validation.Valid;
import lk.inventory.entity.User;
import lk.inventory.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @PostMapping
    public User save(@Valid @RequestBody User user) {
        return service.save(user);
    }


    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }


    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return service.getById(id);
    }


    @PutMapping("/{id}")
    public User update(@PathVariable Long id,
                       @Valid @RequestBody User user) {

        return service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);
        return "User Deleted Successfully";
    }
}
