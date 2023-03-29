package com.loctell.service;

import com.loctell.module.Products;
import com.loctell.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Products addProduct(Products products){
        return productRepository.save(products);
    }

    public Products getProductById(int productId) {
        return  productRepository.findById(productId);
    }
}
