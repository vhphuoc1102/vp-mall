package com.phuocvh.controller;

import com.phuocvh.dto.pmsProductRecommend.PmsProductRecommendRequest;
import com.phuocvh.dto.pmsProductRecommend.PmsProductRecommendResponse;
import com.phuocvh.service.PmsProductRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/recommend")
public class PmsProductRecommendController {
    @Autowired
    private PmsProductRecommendService pmsProductRecommendService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PmsProductRecommendRequest pmsProductRecommendRequest) {
        try {
            pmsProductRecommendService.create(pmsProductRecommendRequest);
            return ResponseEntity.ok("Create successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/getCurrent")
    public ResponseEntity<?> getCurrentRecommendProducts() {
        try {
            PmsProductRecommendResponse response = pmsProductRecommendService.getCurrentRecommendProducts();
            if (response != null) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Not found recommend products");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
