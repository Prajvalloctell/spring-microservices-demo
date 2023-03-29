package com.loctell.service;

import com.loctell.modules.Orders;
import com.loctell.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Orders placeOrder(Orders orders){
        return orderRepository.save(orders);
    }

    public Optional<Orders> getOrderByUserId(int id){
        return orderRepository.findById(id);
    }
}
