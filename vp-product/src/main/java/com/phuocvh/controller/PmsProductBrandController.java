package com.phuocvh.controller;

import com.phuocvh.entity.PmsProductBrand;
import com.phuocvh.service.PmsProductBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/brand")
public class PmsProductBrandController {
    @Autowired
    PmsProductBrandService pmsProductBrandService;

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable String id) {
        try {
            PmsProductBrand pmsProductBrand = pmsProductBrandService.getBrand(id);
            return ResponseEntity.ok(pmsProductBrand);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
