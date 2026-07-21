package lk.inventory.controller;

import jakarta.persistence.Column;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {

    @GetMapping
    public String manager(){
        return "Manager";
    }
}
