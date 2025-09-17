package com.adarsh.shop.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
  Optional<Product> findBySku(String sku);

  @Query("""
    SELECT p FROM Product p
    WHERE (:q IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%',:q,'%'))
       OR LOWER(p.sku) LIKE LOWER(CONCAT('%',:q,'%'))
       OR LOWER(p.description) LIKE LOWER(CONCAT('%',:q,'%')))
  """)
  Page<Product> search(String q, Pageable pageable);
}
