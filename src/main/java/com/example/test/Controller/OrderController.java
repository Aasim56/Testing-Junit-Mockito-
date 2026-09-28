package com.example.test.Controller;

import com.example.test.Entity.Order;
import com.example.test.Service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private static final Logger log =
            LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders/id/{id}")
    public Order getOrder(@PathVariable Integer id){
        log.info("Received request to get Order {} ", id);
        return orderService.getOrder(id);
    }

}
