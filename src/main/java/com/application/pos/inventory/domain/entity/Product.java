package com.application.pos.inventory.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table
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
