package com.hong.flyway.domain;

import java.io.Serializable; 
import java.util.List;
import java.util.ArrayList;

import java.util.Date;
import java.time.LocalDateTime;

import lombok.Data;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.PrePersist;
// import jakarta.persistence.Table;
import jakarta.persistence.*;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;


@Data
@Entity
@Table(name="cart")
public class Cart implements Serializable {
  // private static final long serialVersionUID = 1L; 
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  // @NotBlank(message="Delivery name is required")
  private String uuid;

  // private Date placedAt;
  private LocalDateTime placedAt;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart", orphanRemoval = true)
  private List<Taco> tacos = new ArrayList<>();

  // @ManyToOne
  // private User user;  

  public Cart() {
    // No initialization logic
  }

  public void addTaco(Taco taco) {
    taco.setCart(this); 
    this.tacos.add(taco);
  }

  public void removeTaco(Taco taco) {
    taco.setCart(null); // ??
    this.tacos.remove(taco);
  }

  @PrePersist
  void placedAt() {
    this.placedAt = LocalDateTime.now();
  }

}
