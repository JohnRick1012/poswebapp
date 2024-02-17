package com.application.pos.inventory.interfaces.api.rest.v1.controller;

import com.application.pos.inventory.domain.dto.request.ProductDto;
import com.application.pos.inventory.domain.dto.response.ProductResponseDto;
import com.application.pos.inventory.infrastructure.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pos/inventory-service")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<ProductResponseDto>> saveProduct(
            @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.saveProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<ProductResponseDto>> getProductByProductId(
            @PathVariable Long productId) {
        return ResponseEntity.ok(productService.getProductId(productId));
    }
}
