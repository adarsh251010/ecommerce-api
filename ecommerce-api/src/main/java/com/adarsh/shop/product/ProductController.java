package com.adarsh.shop.product;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductController {

  private final ProductService service;

  public ProductController(ProductService service){ this.service = service; }

  @GetMapping
  public Page<Product> list(@RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "10") int size,
                            @RequestParam(defaultValue = "id") String sortBy,
                            @RequestParam(defaultValue = "asc") String dir,
                            @RequestParam(required = false) String q) {
    Sort sort = Sort.by(dir.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC, sortBy);
    return service.list(q, PageRequest.of(page, size, sort));
  }

  @GetMapping("/{id}")
  public Product get(@PathVariable Long id) {
    return service.get(id);
  }

  @PostMapping
  public ResponseEntity<Product> create(@Valid @RequestBody Product p) {
    return ResponseEntity.ok(service.create(p));
  }

  @PutMapping("/{id}")
  public Product update(@PathVariable Long id, @Valid @RequestBody Product p) {
    return service.update(id, p);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
