package com.phuocvh.clients.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "VP-PRODUCT")
public interface ProductClient {
    @GetMapping("api/v0/category/listTree")
    List<ProductCategoryTreeResponse> getCategoryTree();
}
