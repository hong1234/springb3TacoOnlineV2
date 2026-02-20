package com.hong.flyway.domain;

import lombok.Data;
// import java.math.BigDecimal;

import jakarta.validation.constraints.*;

@Data
public class QtyDTO {

    @NotNull(message = "Modus is required.")
    @Pattern(regexp = "^(add|remove)$", message = "modus must be 'add' or 'remove'")
    private String modus;

    @NotNull(message = "uuid is required.")
    private String uuid;

    // @NotBlank(message = "ProductID is required.")
    private Integer tacoId;

}