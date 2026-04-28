package co.simplon.wishmegift.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.simplon.wishmegift.entity.User;
import co.simplon.wishmegift.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            User savedUser = userService.registerUser(user);
            return ResponseEntity.ok("Utilisateur enregistré avec succès : " + savedUser.getEmail());
        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}