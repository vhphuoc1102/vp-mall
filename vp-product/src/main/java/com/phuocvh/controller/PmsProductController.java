package com.phuocvh.controller;

import com.phuocvh.entity.PmsProduct;
import com.phuocvh.service.PmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/products")
public class PmsProductController {
    @Autowired
    PmsProductService pmsProductService;

    @PostMapping("/register")
    public ResponseEntity<String> registerProduct(@RequestBody PmsProduct productParam) {
        try {
            pmsProductService.registerProduct(productParam);
            return new ResponseEntity<>("Register success", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>("Register error", HttpStatus.BAD_REQUEST);
        }
    }
}
