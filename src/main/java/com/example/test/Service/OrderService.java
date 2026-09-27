package com.example.test.Service;

import com.example.test.Entity.Order;
import com.example.test.Repository.OrderRepository;
import org.slf4j.*;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    private static final Logger log =
            LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrder(Integer id){

        log.trace("TRACE : Fetching order with id : {} ", id);
        log.debug("DEBUG : Fetching order with id : {} ", id);
        log.info("INFO : Fetching order with id : {} ", id);
        log.warn("WARN : Checking order with id : {} ", id);
        log.error("ERROR : Checking order with id : {} ", id);


        return orderRepository.findById(id).orElseThrow(()
                -> {
            log.error("ERROR : Order not found with id : {} ", id);
            return new RuntimeException("Order not found with id " + id);
        });
    }

    public void cancelOrder(Integer id){
        Order order = orderRepository.findById(id).orElseThrow(()
        ->
                new RuntimeException("Order not Found"));

        orderRepository.save(order);
    }
}
