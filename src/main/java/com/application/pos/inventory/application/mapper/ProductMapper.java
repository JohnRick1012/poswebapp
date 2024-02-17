package com.application.pos.inventory.application.mapper;

import com.application.pos.inventory.domain.dto.request.ProductDto;
import com.application.pos.inventory.domain.dto.response.ProductResponseDto;
import com.application.pos.inventory.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product productDtoToEntity(ProductDto productDto);
    ProductResponseDto productToProductResponseDto(Product product);
}
