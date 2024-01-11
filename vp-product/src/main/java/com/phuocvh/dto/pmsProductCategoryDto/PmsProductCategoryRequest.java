package com.phuocvh.dto.pmsProductCategoryDto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PmsProductCategoryRequest {
    private String name;
    private Integer level;
    private Integer productCount;
    private Integer navStatus;
    private Integer showStatus;
    private String icon;
    private String keywords;
    private String description;

    private List<UUID> pmsProductAttributes;

    private UUID parentCategory;
    private List<UUID> childrenCategories;
}
