package tp4.enit.service;

import org.springframework.stereotype.Service;
import tp4.enit.entity.User;
import tp4.enit.repository.UserRepository;
import tp4.enit.service.HashUtils;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register a new user with hashed password
    public User registerUser(User user) {
        if (user.getFirstName() != null && user.getLastName() != null &&
                user.getEmail() != null && user.getPassword() != null) {
            // Hash the user's password before saving
            String salt = generateSalt();
            user.setSalt(salt);

            user.setPassword(HashUtils.hashPassword(user.getPassword()));
            System.out.print(user.getPassword());

            return userRepository.save(user);
        } else {
            throw new RuntimeException("Invalid user information");
        }
    }

    // Authenticate user
    public User signIn(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(HashUtils.hashPassword(user.getPassword()))) {
            return user;
        } else {
            throw new RuntimeException("Invalid email or password");
        }
    }

    // Get user by email
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}
