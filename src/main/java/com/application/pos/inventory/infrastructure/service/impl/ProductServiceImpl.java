package com.application.pos.inventory.infrastructure.service.impl;

import com.application.pos.inventory.application.mapper.ProductMapper;
import com.application.pos.inventory.domain.dto.common.ResponseStatus;
import com.application.pos.inventory.domain.dto.request.ProductDto;
import com.application.pos.inventory.domain.dto.response.ProductResponseDto;
import com.application.pos.inventory.domain.entity.Product;
import com.application.pos.inventory.infrastructure.configuration.properties.SuccessResponseProperties;
import com.application.pos.inventory.infrastructure.repository.ProductRepository;
import com.application.pos.inventory.infrastructure.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final SuccessResponseProperties successResponseProperties;

    private static final ProductMapper productMapper = ProductMapper.INSTANCE;

    @Override
    public Mono<ProductResponseDto> saveProduct(ProductDto productDto) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Product product = productMapper.productDtoToEntity(productDto);

        product.setInventoryDate(localDateTime);

        return productRepository.save(product)
                .flatMap(prod -> {
                    String patterm = "yyMMdd";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patterm);
                    Long productId = Long.parseLong(simpleDateFormat.format(new Date()) + prod.getId());
                    prod.setProductId(productId);
                    return productRepository.save(prod)
                            .map(response -> ProductResponseDto.builder()
                                    .status(ResponseStatus.builder()
                                            .code(successResponseProperties.getCode())
                                            .description(successResponseProperties.getDescription())
                                            .build())
                                    .productId(prod.getProductId())
                                    .productName(prod.getProductName())
                                    .productDescription(prod.getProductDescription())
                                    .price(prod.getPrice())
                                    .qty(prod.getQty())
                                    .inventoryDate(prod.getInventoryDate())
                                    .build());
                });
    }

    @Override
    public Mono<ProductResponseDto> getProductId(Long productId) {
        return productRepository.findByProductId(productId)
                .map(product -> {
                    ProductResponseDto responseDto = productMapper.productToProductResponseDto(product);
                    responseDto.setStatus(ResponseStatus.builder()
                                    .code(successResponseProperties.getCode())
                                    .description(successResponseProperties.getDescription())
                                    .build());
                    return responseDto;
                });
    }
}
