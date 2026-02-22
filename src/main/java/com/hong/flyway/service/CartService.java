package com.hong.flyway.service;

import java.util.List;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import com.hong.flyway.repository.*;
import com.hong.flyway.domain.*;

@Transactional
@RequiredArgsConstructor
@Service
public class CartService {

    private final CartRepository cartRepository;
    private final IngredientRepository ingredientRepository;
    private final OrderRepository orderRepository;

    public Cart getCart(Integer cartId) throws ServiceException {
        Cart cart = cartRepository.findById(cartId).get(); 
        return cart;
    }

    public Cart getCartByUuid(String uuId) throws ServiceException {
        return getCartByUUID(uuId); 
    }

    public CartREC addTaco(TacoDTO dto) throws ServiceException {  
        int[] ingredients = dto.getIngredients();
        List<Ingredient> ings = ingredientRepository.findAll();

        // ings.forEach((ing) -> {
        //     System.out.print(ing.getId());
        //     System.out.print("-");
        // });
        
        Taco taco = new Taco();
        taco.setName(dto.getName());
        taco.setQty(dto.getQty());
        taco.setUnitPrice(BigDecimal.ZERO);

        for (int i = 0; i < ingredients.length; i++){
            for (Ingredient ing : ings) {
                if (ing.getId() == ingredients[i]) {
                    taco.addIngredient(ing);
                    taco.setUnitPrice(ing.getUnitPrice().add(taco.getUnitPrice()));
                    break;
                }
            }
        }
    
        // for (int i = 0; i < ingredients.length; i++){
        //     taco.addIngredient(ings.get(ingredients[i] - 1));
        // }

        // for (int i = 0; i < ingredients.length; i++){
        //     taco.addIngredient(ingredientRepository.findById(ingredients[i]).get()); 
        // }

        Cart cart = getCartByUUID(dto.getUuid());
        cart.addTaco(taco);
        cart = cartRepository.save(cart);
        return cartRecord(cart);

        // return new CartREC(
        //     1,
        //     "abcd"
        // );
    }

    public CartREC qtyPlus(QtyDTO dto){
        Cart cart =  getCartByUUID(dto.getUuid());

        for (Taco taco : cart.getTacos()) {
            if(taco.getId().equals(dto.getTacoId())) {
                taco.setQty(taco.getQty() + 1);
                break;
            }
        }

        cart = cartRepository.save(cart);
        // return cart;
        return cartRecord(cart); 
    }

    public CartREC qtyMinus(QtyDTO dto){
        Cart cart =  getCartByUUID(dto.getUuid());
        
        for (Taco taco : cart.getTacos()) {
            if(taco.getId().equals(dto.getTacoId())) {
                if(taco.getQty().equals(1)) {
                    cart.removeTaco(taco);
                } else {
                    taco.setQty(taco.getQty() - 1);
                }
                break;
            }
        }

        cart = cartRepository.save(cart);
        // return cart;
        return cartRecord(cart);
    }

    public OrderREC cartCheckOut(OrderDTO dto) throws ServiceException {

        Cart cart = getCartByUUID(dto.getUuid());

        Order order = new Order();
        order.setUuid(dto.getUuid());
        order.setDeliveryName(dto.getDeliveryName());
        order.setDeliveryStreet(dto.getDeliveryStreet());
        order.setDeliveryCity(dto.getDeliveryCity());
        order.setCcNumber(dto.getCcNumber());
        order.setShipmentPrice(new BigDecimal("4.99")); 
        // order.setCustomer(cart.getCustomer());  

        Item temp;
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal sum = BigDecimal.ZERO;

        for (Taco taco : cart.getTacos()) {
            temp = new Item();
            temp.setName(taco.getName());
            temp.setQty(taco.getQty());
            temp.setUnitPrice(taco.getUnitPrice());
            temp.setIngredients(taco.getIngredients());

            sum = BigDecimal.valueOf(taco.getQty()).multiply(taco.getUnitPrice());
            temp.setSumPrice(sum);

            temp.setOrder(order);
            order.getItems().add(temp);

            // total = BigDecimal.valueOf(taco.getQty()).multiply(taco.getUnitPrice()).add(total);
            total = sum.add(total);
            sum = BigDecimal.ZERO;
        }

        order.setItemsPrice(total);

        total = BigDecimal.valueOf(Double.valueOf("4.99")).add(total);

        order.setTotalPrice(total);

        order = orderRepository.save(order);
        
        cartRepository.deleteById(cart.getId());

        return orderRecord(order);
    }

    public CartREC cartRecord(Cart cart) {
        return new CartREC(
            cart.getId(),
            cart.getUuid()
        );
    }

    public OrderREC orderRecord(Order order) {
        return new OrderREC(
            order.getId(),
            order.getUuid()
        );
    }

    public Cart getCartByUUID(String uuId) {
        Cart cart = cartRepository.findByUuid(uuId).orElse(new Cart());
        if (cart.getId()==null) {
            cart.setUuid(uuId);
            cart = cartRepository.save(cart);
        }
        return cart;
    }

    // public Cart getCartByUUID(String uuId) { 
    //     Optional<Cart> optionalCart = cartRepository.findById(1);
    //     if (optionalCart.isPresent()) {
    //         return optionalCart.get(); 
    //     } else {
    //         Cart cart = new Cart();
    //         cart.setUuid(uuId);
    //         return cartRepository.save(cart);
    //     }
    // }

}