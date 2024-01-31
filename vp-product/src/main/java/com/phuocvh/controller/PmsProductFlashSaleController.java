package com.phuocvh.controller;

import com.phuocvh.dto.pmsProductFlashSale.PmsProductFlashSaleRequest;
import com.phuocvh.dto.pmsProductFlashSale.PmsProductFlashSaleResponse;
import com.phuocvh.service.PmsProductFlashSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/flashsale")
public class PmsProductFlashSaleController {
    @Autowired
    private PmsProductFlashSaleService pmsProductFlashSaleService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PmsProductFlashSaleRequest pmsProductFlashSaleRequest) {
        try {
            pmsProductFlashSaleService.create(pmsProductFlashSaleRequest);
            return ResponseEntity.ok("Create successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/getCurrent")
    public ResponseEntity<?> getCurrentFlashSaleProducts() {
        try {
            PmsProductFlashSaleResponse pmsProductFlashSaleResponse = pmsProductFlashSaleService.getCurrentFlashSaleProducts();
            if (pmsProductFlashSaleResponse != null) {
                return ResponseEntity.ok(pmsProductFlashSaleResponse);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Not found flash sale products");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
