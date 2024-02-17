package com.application.pos.inventory.infrastructure.service;

import com.application.pos.inventory.domain.dto.request.ProductDto;
import com.application.pos.inventory.domain.dto.response.ProductResponseDto;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<ProductResponseDto> saveProduct(ProductDto productDto);
    Mono<ProductResponseDto> getProductId(Long productId);
}
