package lk.inventory.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {

    public ResponseEntity<String> exceptionHandler( RuntimeException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
