package com.adarsh.shop.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
  Page<Product> list(String q, Pageable pageable);
  Product get(Long id);
  Product create(Product p);
  Product update(Long id, Product p);
  void delete(Long id);
}
