package com.loctell.controller;

import com.loctell.enums.OrderStatus;
import com.loctell.modules.Orders;
import com.loctell.modules.Products;
import com.loctell.repository.OrderRepository;
import com.loctell.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    private RestTemplate restTemplate;

    public OrderController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/place-order/{product_id}")
    public ResponseEntity<String> placeOrderByID(@PathVariable int product_id) {
        Products products = restTemplate.getForObject("http://localhost:5054/product/" + product_id, Products.class);
        if (products == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
        Orders order = new Orders();
        order.setProduct(products);
        order.setStatus(OrderStatus.ORDER_CREATED);
        orderRepository.save(order);
        return new ResponseEntity<>("Order created", HttpStatus.OK);
    }
}
