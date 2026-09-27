package com.example.test.Service;

import com.example.test.Entity.Order;
import com.example.test.Repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrder(Integer id){
        return orderRepository.findById(id).orElseThrow(()
                -> new RuntimeException(" Order not found with Id "));
    }

    public void cancelOrder(Integer id){
        Order order = orderRepository.findById(id).orElseThrow(()
        ->
                new RuntimeException("Order not Found"));

        orderRepository.save(order);
    }
}
