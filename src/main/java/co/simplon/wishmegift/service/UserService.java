package co.simplon.wishmegift.service;

import org.springframework.stereotype.Service;

import co.simplon.wishmegift.entity.User;
import co.simplon.wishmegift.repository.UserRepository;
import java.util.regex.Pattern;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private static final String PASSWORD_PATTERN =
    "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{12,}$";

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Cet email est déjà utilisé !");
        }

        if (!Pattern.matches(PASSWORD_PATTERN, user.getPassword())) {
            throw new RuntimeException("Le mot de passe ne respecte pas les critères de sécurité !");
        }

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }
}
