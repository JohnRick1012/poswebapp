package com.application.pos.inventory.infrastructure.repository;

import com.application.pos.inventory.domain.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {

}
