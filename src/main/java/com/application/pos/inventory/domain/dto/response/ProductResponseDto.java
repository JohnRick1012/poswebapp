package com.application.pos.inventory.domain.dto.response;

import com.application.pos.inventory.domain.dto.common.ResponseStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ProductResponseDto {

    private ResponseStatus status;
    private Long productId;
    private String productName;
    private String productDescription;
    private Double price;
    private Long qty;
    private LocalDateTime inventoryDate;
}
