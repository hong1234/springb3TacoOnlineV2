package com.hong.flyway.controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.hong.flyway.domain.*;
import com.hong.flyway.service.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController { 

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // @GetMapping("/{orderId}")
    // public Order getOrder(@PathVariable Integer orderId) throws ServiceException {
    //     return orderService.getOrder(orderId); 
    // }

    @GetMapping("/{orderUuid}")
    public Order getOrderByUuid(@PathVariable String orderUuid) throws ServiceException {
        return orderService.getOrderByUuid(orderUuid); 
    }
}