package tp4.enit.controller;


import org.springframework.web.bind.annotation.*;
import tp4.enit.entity.Product;
import tp4.enit.repository.ProductRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") // Specify your Angular app URL
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
