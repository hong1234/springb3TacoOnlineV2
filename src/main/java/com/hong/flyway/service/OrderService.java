package com.hong.flyway.service;

// import java.util.UUID;
import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.hong.flyway.repository.*;
import com.hong.flyway.domain.*;

@Transactional
@RequiredArgsConstructor
@Service
public class OrderService {

    // private final TacoRepository tacoRepository; 
    // private final IngredientRepository ingredientRepository;
    private final OrderRepository orderRepository;

    public Order getOrder(Integer orderId) throws ServiceException {
        Order order = orderRepository.findById(orderId).get(); 
        return order;
    }

    public Order getOrderByUuid(String orderUuid) throws ServiceException {
        // Order order = orderRepository.findByUuid(orderUuid).get(); // return order;
        Order order = orderRepository.findByUuid(orderUuid).orElse(new Order());
        if (order.getId()==null) {
            order.setId(0);
            order.setUuid(orderUuid);
        }
        return order;
    }

}