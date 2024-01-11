package com.phuocvh.clients.product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProductCategoryTreeResponse {
    private UUID id;
    private String name;
    private List<ProductCategoryTreeResponse> pmsProductCategoryTrees;
}
