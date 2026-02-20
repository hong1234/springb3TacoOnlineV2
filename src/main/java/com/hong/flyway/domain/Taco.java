package com.hong.flyway.domain;

import java.util.Date;
import java.time.LocalDateTime;
import java.math.BigDecimal;

import java.util.Set;
import java.util.HashSet;

import java.util.List;
import java.util.ArrayList;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.PrePersist; 

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;

// @NoArgsConstructor 
@Data
@Entity
@Table(name="taco")
public class Taco {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  
  @NotNull
  @Size(min=5, message="Name must be at least 5 characters long")
  private String name; 
  private BigDecimal unitPrice;
  private Integer qty;
  private LocalDateTime createdAt; //  = LocalDateTime.now();

  // @ManyToMany(targetEntity=Ingredient.class)
  // @Size(min=1, message="You must choose at least 1 ingredient")
  // private List<Ingredient> ingredients;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(
    name="taco_ingredient",
    joinColumns=@JoinColumn(name="taco_id"), 
    inverseJoinColumns=@JoinColumn(name="ingredient_id")
  )
  private Set<Ingredient> ingredients = new HashSet<>();
  // private List<Ingredient> ingredients = new ArrayList<>(); 

  // @JsonIgnore
  // @ManyToOne(fetch = FetchType.LAZY)
  // @JoinColumn(name = "order_id")
  // private Order order;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "cart_id")
  private Cart cart;

  public Taco() {
    // No initialization logic 
  }

  public void addIngredient(Ingredient ingredient) {
    this.ingredients.add(ingredient);
  }

  @PrePersist
  void createdAt() {
    this.createdAt = LocalDateTime.now(); // new Date();
  }
}
