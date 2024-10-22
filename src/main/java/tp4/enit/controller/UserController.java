package tp4.enit.controller;

import org.springframework.web.bind.annotation.*;
import tp4.enit.entity.User;
import tp4.enit.repository.UserRepository;
import tp4.enit.service.HashUtils;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register a new user
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        if (user.getFirstName() != null && user.getLastName() != null &&
                user.getEmail() != null && user.getPassword() != null) {
            user.setPassword(HashUtils.hashPassword(user.getPassword()));
            return userRepository.save(user);
        } else {
            throw new RuntimeException("Invalid user information");
        }
    }

    // Sign in a user
    @PostMapping("/sign-in")
    public User signIn(@RequestBody User user) {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null && existingUser.getPassword().equals(HashUtils.hashPassword(user.getPassword()))) {
            return existingUser;
        } else {
            throw new RuntimeException("Invalid user credentials.");
        }
    }
}
