package com.hong.flyway.domain;

import java.math.BigDecimal;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Enumerated;
import jakarta.persistence.*;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


// @NoArgsConstructor
@Data
@Entity
@Table(name="ingredient") 
public class Ingredient {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  private String mark;
  private String name;
  private BigDecimal unitPrice;

  @Enumerated(EnumType.STRING)
  @Column(name = "ingredient_type")
  private IngredientType ingredientType;

  public Ingredient() {
    // No initialization logic
  }

  // public enum IngredientType {
  //   WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  // }

}
