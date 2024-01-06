package com.phuocvh.controller;

import com.phuocvh.dto.PmsProductRequest;
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
    public ResponseEntity register(@RequestBody PmsProductRequest pmsProductRequest) {
        try {
            pmsProductService.create(pmsProductRequest);
            return ResponseEntity.ok("Create successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity listAll() {
        try {
            List<PmsProduct> productList = pmsProductService.list();
            return ResponseEntity.ok(productList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

//    @GetMapping("/list")
//
//    public ResponseEntity list() {
//        try {
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return ResponseEntity.internalServerError().body(e.getMessage());
//        }
//    }

    @PostMapping("/update/{id}")
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

    @DeleteMapping("/delete/{id}")
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
