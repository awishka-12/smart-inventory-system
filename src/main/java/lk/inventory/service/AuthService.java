package lk.inventory.service;

import lk.inventory.dto.LoginRequest;
import lk.inventory.dto.LoginResponse;
import lk.inventory.entity.User;
import lk.inventory.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lk.inventory.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private static final Logger logger =
            LoggerFactory.getLogger(AuthService.class);

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    private void jwt() {
    }


    public LoginResponse login(LoginRequest request) {

        logger.info("Login attempt: {}", request.getEmail());

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> {
                    logger.warn("User not found: {}", request.getEmail());
                    return new RuntimeException("User not found");
                });

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {

            logger.warn("Invalid password: {}", request.getEmail());

            throw new RuntimeException("Wrong password");
        }

        String token = jwtService.generateToken(user.getEmail());

        logger.info("Login successful: {}", request.getEmail());

        return new LoginResponse(token);
    }
}
