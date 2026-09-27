package com.example.test;

import com.example.test.Entity.Order;
import com.example.test.Repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;


    @Test
    void shouldSaveAndFindOrder(){

        Order order = new Order();
        order.setProductName("MSI GF 63 Thin");
        order.setAmount(50000);

        Order saveOrder = orderRepository.save(order);

        Optional<Order> foundOrder = orderRepository.findById(saveOrder.getId());

        assertTrue(foundOrder.isPresent());
        assertEquals(saveOrder.getId(), foundOrder.get().getId());
        assertEquals(saveOrder.getProductName(), foundOrder.get().getProductName());
        assertEquals(saveOrder.getAmount(), foundOrder.get().getAmount());
    }
}
