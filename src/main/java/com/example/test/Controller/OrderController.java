package com.example.test.Controller;

import com.example.test.Entity.Order;
import com.example.test.Service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders/id/{id}")
    public Order getOrder(@PathVariable Integer id){
        return orderService.getOrder(id);
    }

}
