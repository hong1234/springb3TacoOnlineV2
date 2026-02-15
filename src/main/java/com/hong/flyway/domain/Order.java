package com.hong.flyway.domain;

import java.io.Serializable; 
import java.util.List;
import java.util.ArrayList;

import java.util.Date;
import java.time.LocalDateTime;
import java.math.BigDecimal;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber; 
import lombok.Data;


@Data
@Entity
@Table(name="orders")
public class Order implements Serializable {
  // private static final long serialVersionUID = 1L;    
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  // @NotBlank(message="Delivery name is required")
  private String uuid;

  @NotBlank(message="Delivery name is required")
  private String deliveryName;

  @NotBlank(message="Street is required")
  private String deliveryStreet;

  @NotBlank(message="City is required")
  private String deliveryCity;

  // @NotBlank(message="State is required") 
  // private String deliveryState;

  // @NotBlank(message="Zip code is required")
  // private String deliveryZip;

  // @CreditCardNumber(message="Not a valid credit card number")
  private String ccNumber;

  // private Date placedAt;
  private LocalDateTime placedAt;  // = LocalDateTime.now();

  // @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="Must be formatted MM/YY")
  // private String ccExpiration;

  // @Digits(integer=3, fraction=0, message="Invalid CVV")
  // private String ccCVV; 

  // @ManyToMany(targetEntity=Taco.class)
  // private List<Taco> tacos = new ArrayList<>();

  // @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", orphanRemoval = true)
  // private List<Taco> tacos = new ArrayList<>();

  @Column(name = "items_price")
  private BigDecimal itemsPrice;

  @Column(name = "shipment_price")
  private BigDecimal shipmentPrice;

  @Column(name = "total_price")
  private BigDecimal totalPrice;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", orphanRemoval = true)
  private List<Item> items = new ArrayList<>();  // Item == Taco

  // @ManyToOne
  // private User user; 

  public Order() {
    // No initialization logic
  }

  public void addItem(Item item) {
    item.setOrder(this); 
    this.items.add(item);
  }

  public void removeItem(Item item) {
    // taco.setOrder(null); // ??
    this.items.remove(item);
  }

  @PrePersist
  void placedAt() {
    this.placedAt = LocalDateTime.now(); // new Date();
  }

}
