package com.hong.flyway.domain;

import lombok.Data;
import java.math.BigDecimal;

import jakarta.validation.constraints.*;

@Data
public class OrderDTO { 

    @NotBlank(message = "uuid is required.")
    private String uuid;  // cart id

    @NotBlank(message = "deliveryName is required.")
    private String deliveryName; 

    @NotBlank(message = "deliveryStreet is required.")
    private String deliveryStreet;

    @NotBlank(message = "deliveryCity is required.")
    private String deliveryCity;
    
    // @CreditCardNumber(message="Not a valid credit card number")
    @NotBlank(message = "ccNumber is required.")
    private String ccNumber;
}