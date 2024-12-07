package com.delogic.tickets.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDTO {
    private Long categoryId;
    private String group;
    private String name;
    private String description;
}