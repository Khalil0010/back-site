package tp4.enit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tp4.enit.entity.Cart;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    // Custom query to find a cart by user's email
    //Optional<Cart> findByUserEmail(String email);
}
