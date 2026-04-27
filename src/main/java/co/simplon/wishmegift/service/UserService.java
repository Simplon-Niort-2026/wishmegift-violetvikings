package co.simplon.wishmegift.service;

import org.springframework.stereotype.Service;

import co.simplon.wishmegift.entity.User;
import co.simplon.wishmegift.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Cet email est déjà utilisé !");
        }

        // Penser à hasher le mot de passe avant sauvegarde + regex mot de passe
        return userRepository.save(user);
    }
}
