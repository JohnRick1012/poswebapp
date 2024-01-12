package com.application.pos.inventory.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Product {

    @Id
    private Long id;
    private Long productId;
    private String productName;
    private String productDescription;
    private Double price;
    private Long qty;
    private LocalDateTime inventoryDate;

}
