package tp4.enit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tp4.enit.entity.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final List<Product> cart = new ArrayList<>(); // In-memory cart for demonstration

    // Get the current cart
    @GetMapping
    public ResponseEntity<List<Product>> getCart() {
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    // Add a product to the cart
    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody Product product) {
        cart.add(product);
        return new ResponseEntity<>("Product added to cart", HttpStatus.OK);
    }

    // Remove a product from the cart
    @PostMapping("/remove")
    public ResponseEntity<String> removeFromCart(@RequestBody Product product) {
        cart.remove(product);
        return new ResponseEntity<>("Product removed from cart", HttpStatus.OK);
    }
}
