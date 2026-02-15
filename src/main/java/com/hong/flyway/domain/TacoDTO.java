package com.hong.flyway.domain;

import lombok.Data;
import java.math.BigDecimal;

import jakarta.validation.constraints.*;

@Data
public class TacoDTO {
    
    @NotBlank(message = "uuid is required.")
    private String uuid;  // cart id

    @NotBlank(message = "name is required.")
    private String name; 

    private int[] ingredients;

    private int qty;

    // @NotBlank(message = "description is required.")
    // private String description;

    // @NotBlank(message = "supplier is required.")
    // private String supplier;

    // @NotBlank(message = "searchkeys is required.")
    // private String searchkeys;

    // @NotBlank(message = "image is required.")
    // private String image;

    // @Digits(integer=6, fraction=2)
    // @NotNull(message = "price is required.")
    // private BigDecimal unitPrice;

    // @NotBlank(message = "category is required.")
    // private String categoryId;

    // @Pattern(regexp = "^d+.d+$", message = "price is invalid format")
    // @NotBlank(message = "price is required.")
    // private String unitPrice;
}
