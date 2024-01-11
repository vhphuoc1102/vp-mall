package com.phuocvh.controller;

import com.phuocvh.dto.pmsProductDto.PmsProductQueryParam;
import com.phuocvh.dto.pmsProductDto.PmsProductRequest;
import com.phuocvh.entity.PmsProduct;
import com.phuocvh.service.PmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/products")
public class PmsProductController {
    @Autowired
    private PmsProductService pmsProductService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody PmsProductRequest pmsProductRequest) {
        try {
            pmsProductService.create(pmsProductRequest);
            return ResponseEntity.ok("Create successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<?> listAll() {
        try {
            List<PmsProduct> productList = pmsProductService.listAll();
            return ResponseEntity.ok(productList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> list(
            @RequestBody PmsProductQueryParam pmsProductQueryParam,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
    ) {
        try {
            List<PmsProduct> productList = pmsProductService.list(pmsProductQueryParam, pageSize, pageNum);
            return ResponseEntity.ok(productList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        try {
            PmsProduct pmsProduct = pmsProductService.get(id);
            if (pmsProduct != null) return ResponseEntity.ok(pmsProduct);
            else return ResponseEntity.notFound().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody PmsProductRequest pmsProductRequest) {
        try {
            int result = pmsProductService.update(id, pmsProductRequest);
            if (result == 1) return ResponseEntity.ok("Updated successfully");
            else return ResponseEntity.notFound().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        try {
            pmsProductService.delete(id);
            return ResponseEntity.ok("Deleted successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
