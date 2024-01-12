package com.application.pos.inventory.domain.dto.request;

import lombok.Data;

@Data
public class ProductDto {

    private String productName;
    private String productDescription;
    private Double price;
    private Long qty;

}
