package com.phuocvh.controller;

import com.phuocvh.clients.product.ProductCategoryTreeResponse;
import com.phuocvh.clients.product.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v0")
public class PortalController {
    @Autowired
    ProductClient productClient;

    @GetMapping("/category/listTree")
    public ResponseEntity listTree() {
        try {
            System.out.println("DEBUG 1");
            List<ProductCategoryTreeResponse> productCategoryTreeResponse = productClient.getCategoryTree();
            return ResponseEntity.ok(productCategoryTreeResponse);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
