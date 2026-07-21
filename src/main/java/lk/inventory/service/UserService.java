package lk.inventory.service;

import lk.inventory.entity.User;
import lk.inventory.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public User save(User user) {

        user.setCreatedAt(LocalDateTime.now());
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatus(true);

        return repository.save(user);
    }

    public List<User> getAll() {
        return repository.findAll();
    }


    public User getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }


    public User update(Long id, User user) {

        User existingUser = getById(id);

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        existingUser.setStatus(user.getStatus());

        return repository.save(existingUser);
    }


    public void delete(Long id) {

        User user = getById(id);
        repository.delete(user);
    }
}
