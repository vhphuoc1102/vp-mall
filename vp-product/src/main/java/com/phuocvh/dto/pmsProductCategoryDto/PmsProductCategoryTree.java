package com.phuocvh.dto.pmsProductCategoryDto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PmsProductCategoryTree {
    private UUID id;
    private String name;
    private List<PmsProductCategoryTree> items;
}