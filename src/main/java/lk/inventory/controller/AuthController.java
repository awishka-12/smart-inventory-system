package lk.inventory.controller;

import lk.inventory.dto.LoginRequest;
import lk.inventory.dto.LoginResponse;
import lk.inventory.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) throws Exception {
        return authService.login(loginRequest);
    }
}
