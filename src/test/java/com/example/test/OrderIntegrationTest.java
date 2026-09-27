package com.example.test;

import com.example.test.Repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void  shouldReturnOrderById() throws Exception {

//        Order order = new Order();
//        order.setProductName("MacBook Pro");
//        order.setAmount(35000);
//
//        Order saveOrder = orderRepository.save(order);

        mockMvc.perform
                (MockMvcRequestBuilders.get("/orders/id/3" ))
                .andExpect(status().isOk());
    }
}
