package com.example.test;

import com.example.test.Entity.Order;
import com.example.test.Repository.OrderRepository;
import com.example.test.Service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @InjectMocks
    OrderService orderService;

    Order order = new Order(1001,
            "MacBook Pro",
            250000);


    @Test
    void shouldReturnOrderWhenOrderExists() {

        when(orderRepository.findById(1001))
                .thenReturn(Optional.of(order));

        Order Result = orderService.getOrder(1001);

        assertEquals(1001, order.getId());
        assertEquals("MacBook Pro", order.getProductName());
        assertEquals(250000, order.getAmount());

        verify(orderRepository, times(1))
                .findById(1001);
    }

    @Test
    void shouldThrowExceptionWhenOrderNotExists(){

        when(orderRepository.findById(1099))
                .thenReturn(Optional.empty());


        RuntimeException exception =
                assertThrows(RuntimeException.class,
                () -> orderService.getOrder(1099));

        assertEquals(" Order not found with Id ", exception.getMessage());
    }

    @Test
    void shouldNotSaveOrderWhenOrderDoesNotExists(){

        when(orderRepository.findById(99))
                .thenReturn(Optional.empty());

        assertThrows(RuntimeException.class,
                () -> orderService.cancelOrder(99));

        verify(orderRepository, never())
                .save(any(Order.class));

    }

}

