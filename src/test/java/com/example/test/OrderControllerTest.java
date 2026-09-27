package com.example.test;

import com.example.test.Controller.OrderController;
import com.example.test.Entity.Order;
import com.example.test.Service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
public class OrderControllerTest {
   MockMvc mockMvc;

    @MockitoBean
    OrderService orderService;

    @Test
    void shouldReturnOrder() throws Exception {

        Order order = new Order(2001,
                "IPhone 12 Pro Max",
                55000);

        when(orderService.getOrder(2001))
                .thenReturn(order);

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/orders/id/2001")
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2001))
                .andExpect(jsonPath("$.productName").value("IPhone 12 Pro Max"))
                .andExpect(jsonPath("$.amount").value(55000));

        verify(orderService, times(1))
                .getOrder(2001);
    }
}
