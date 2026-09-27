package com.example.test;

import com.example.test.Entity.Order;
import com.example.test.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class OrderIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;


    @Test
    void  shouldReturnOrderById() throws Exception {

        Order order = new Order();
        order.setProductName("Apple Watch Series 7");
        order.setAmount(18000);


        Order saveOrder = orderRepository.save(order);

        mockMvc.perform
                (MockMvcRequestBuilders.get("/orders/id/"+ saveOrder.getId() ))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(order.getId()))
                .andExpect( jsonPath("$.productName").value("Apple Watch Series 7"))
                .andExpect( jsonPath("$.amount").value(18000));

    }
}
