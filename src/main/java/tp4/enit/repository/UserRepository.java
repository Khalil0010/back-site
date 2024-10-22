package tp4.enit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tp4.enit.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    // Custom query to find a user by email
    User findByEmail(String email);
}
