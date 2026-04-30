package co.simplon.wishmegift.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.simplon.wishmegift.entity.User;
import co.simplon.wishmegift.repository.UserRepository;

import java.util.regex.Pattern;

import org.jspecify.annotations.Nullable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{12,}$";

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
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Ce pseudo est déjà pris !");
        }
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }

    public java.util.List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Utilisateur non trouvé avec l'id : " + id);
        }
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        user.setEmail(userDetails.getEmail());
        if (userDetails.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        }
        return userRepository.save(user);
    }

    public User patchUser(Long id, Map<String, Object> updates) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        updates.forEach((key, value) -> {
            if (key.equals("email"))
                user.setEmail((String) value);
            if (key.equals("username"))
                user.setUsername((String) value);
        });
        return userRepository.save(user);
    }

    public @Nullable User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
