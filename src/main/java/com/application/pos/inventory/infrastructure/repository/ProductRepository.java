package com.application.pos.inventory.infrastructure.repository;

import com.application.pos.inventory.domain.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {

}
