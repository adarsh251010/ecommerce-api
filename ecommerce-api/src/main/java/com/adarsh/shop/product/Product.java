package com.adarsh.shop.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products",
       indexes = {@Index(name="idx_sku", columnList = "sku", unique = true),
                  @Index(name="idx_name", columnList = "name")})
public class Product {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String name;

  @NotBlank
  @Column(nullable = false, unique = true)
  private String sku;

  @NotNull @DecimalMin(value = "0.0", inclusive = false)
  private BigDecimal price;

  @NotNull @Min(0)
  private Integer stock;

  private String description;

  // getters/setters
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getSku() { return sku; }
  public void setSku(String sku) { this.sku = sku; }
  public BigDecimal getPrice() { return price; }
  public void setPrice(BigDecimal price) { this.price = price; }
  public Integer getStock() { return stock; }
  public void setStock(Integer stock) { this.stock = stock; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
}
