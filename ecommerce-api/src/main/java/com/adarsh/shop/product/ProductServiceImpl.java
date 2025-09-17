package com.adarsh.shop.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

  private final ProductRepository repo;

  public ProductServiceImpl(ProductRepository repo){ this.repo = repo; }

  @Override @Transactional(readOnly = true)
  public Page<Product> list(String q, Pageable pageable) {
    String query = (q == null || q.isBlank()) ? null : q.trim();
    return repo.search(query, pageable);
  }

  @Override @Transactional(readOnly = true)
  public Product get(Long id) {
    return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found: " + id));
  }

  @Override
  public Product create(Product p) {
    repo.findBySku(p.getSku()).ifPresent(x -> { throw new IllegalArgumentException("SKU already exists: " + p.getSku()); });
    return repo.save(p);
  }

  @Override
  public Product update(Long id, Product incoming) {
    Product cur = get(id);
    if (!cur.getSku().equalsIgnoreCase(incoming.getSku())) {
      repo.findBySku(incoming.getSku()).ifPresent(x -> { throw new IllegalArgumentException("SKU already exists: " + incoming.getSku()); });
    }
    cur.setName(incoming.getName());
    cur.setSku(incoming.getSku());
    cur.setPrice(incoming.getPrice());
    cur.setStock(incoming.getStock());
    cur.setDescription(incoming.getDescription());
    return cur;
  }

  @Override
  public void delete(Long id) {
    if (!repo.existsById(id)) throw new IllegalArgumentException("Product not found: " + id);
    repo.deleteById(id);
  }
}
