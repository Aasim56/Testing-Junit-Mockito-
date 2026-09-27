package com.example.test;

import com.example.test.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

}
