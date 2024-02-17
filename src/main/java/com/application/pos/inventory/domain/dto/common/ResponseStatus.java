package com.application.pos.inventory.domain.dto.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseStatus {

    private String code;
    private String description;
}

