package com.loctell.controller;

import com.loctell.enums.OrderStatus;
import com.loctell.module.Products;
import com.loctell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Products products){
        Products addedProduct = productService.addProduct(products);
        if (addedProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("PRODUCT ADDED SUCCESSFULLY");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("FAILED TO ADD PRODUCT");
        }
    }

    @GetMapping("/{product_id}")
    public Products getProductsById(
            @PathVariable int product_id){
        return productService.getProductById(product_id);
    }
}
