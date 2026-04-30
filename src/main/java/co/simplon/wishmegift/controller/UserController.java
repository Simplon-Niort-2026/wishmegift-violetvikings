package co.simplon.wishmegift.controller;

import java.util.List;
import java.util.Map;

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
    @GetMapping("/{id}")
public ResponseEntity<User> getUserById(@PathVariable Long id) {
    return ResponseEntity.ok(userService.findById(id));
}

@DeleteMapping("/{id}")
public ResponseEntity<?> delete(@PathVariable Long id) {
    userService.deleteUser(id);
    return ResponseEntity.ok("Utilisateur supprimé avec succès");
}

@PutMapping("/{id}")
public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
    return ResponseEntity.ok(userService.updateUser(id, user));
}

@PatchMapping("/{id}")
public ResponseEntity<User> patch(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
    return ResponseEntity.ok(userService.patchUser(id, updates));
}


}