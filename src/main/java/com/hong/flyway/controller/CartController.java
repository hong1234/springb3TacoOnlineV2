package com.hong.flyway.controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.hong.flyway.domain.*;
import com.hong.flyway.service.*; 

@RestController
@RequestMapping("/api/v1/cart")
public class CartController { 

    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // @GetMapping("/{cartId}")
    // public Cart getCart(@PathVariable Integer cartId) throws ServiceException {
    //     return cartService.getCart(cartId);  
    // }

    @GetMapping("/{uuId}")
    public Cart getCartByUuid(@PathVariable String uuId) throws ServiceException {
        return cartService.getCartByUuid(uuId); 
    }

    @PostMapping("/addtaco")
    public ResponseEntity<CartREC>  addTaco(@RequestBody TacoDTO dto) throws ServiceException {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.addTaco(dto));
    }

    @PutMapping("/qty")
    public ResponseEntity<Cart> QtyUpdate(@RequestBody QtyDTO dto) throws ServiceException {
        String action = dto.getModus();
        Cart newCart = null;
        if(action.equals("add")){
            newCart = cartService.qtyPlus(dto);
        } else {
            newCart = cartService.qtyMinus(dto);
        }
        return ResponseEntity.ok(newCart);
    }

    @PostMapping("/checkout")
    public ResponseEntity<OrderREC> cartCheckout(@RequestBody OrderDTO dto) throws ServiceException {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.cartCheckOut(dto));
    }

    // @GetMapping("/{customerId}/checkout")
    // public Order cartCheckout(@PathVariable String customerId) throws ServiceException {
    //     return cartService.cartCheckOut(customerId);  
    // }

    // @PostMapping("/checkout")
    // public Order cartCheckout(@RequestBody OrderDTO dto) throws ServiceException {
    //     return cartService.cartCheckOut(dto); 
    // }

    // @PostMapping("/checkout")
    // public ResponseEntity<Void> cartCheckout(@RequestBody OrderDTO dto) throws ServiceException {
    //     cartService.cartCheckOut(dto);
    //     return ResponseEntity.ok().build();
    // }
    
}