package tp4.enit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp4.enit.entity.Cart;
import tp4.enit.entity.Product;
import tp4.enit.repository.CartRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
/*
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserService userService; // Assuming this is used to validate users

    // Get the cart by user email
    public Cart getCartByUser(String email) {
        return cartRepository.findByUserEmail(email).orElse(null);
    }

    // Add a product to the cart
    public Cart addProductToCart(String email, Product product) {
        Cart cart = getCartByUser(email);
        if (cart == null) {
            cart = new Cart();
            cart.setProducts(List.of(product)); // Create a new cart if it doesn't exist
        } else {
            cart.getProducts().add(product); // Add the product to the existing cart
        }
        return cartRepository.save(cart); // Save the updated cart
    }

    // Update the cart products
    public Cart updateCartProducts(String email, List<Product> products) {
        Cart cart = getCartByUser(email);
        if (cart != null) {
            cart.setProducts(products); // Update the products in the cart
            return cartRepository.save(cart); // Save the updated cart
        }
        return null; // Return null if the cart does not exist
    }

    // Clear the cart
    public boolean clearCart(String email) {
        Cart cart = getCartByUser(email);
        if (cart != null) {
            cart.getProducts().clear(); // Clear the products from the cart
            cartRepository.save(cart); // Save the cleared cart
            return true; // Return true indicating success
        }
        return false; // Return false if the cart does not exist
    }

 */
}
