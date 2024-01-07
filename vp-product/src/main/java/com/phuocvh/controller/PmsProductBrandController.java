package com.phuocvh.controller;

import com.phuocvh.dto.PmsProductBrandRequest;
import com.phuocvh.entity.PmsProductBrand;
import com.phuocvh.service.PmsProductBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/brand")
public class PmsProductBrandController {
    @Autowired
    PmsProductBrandService pmsProductBrandService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody PmsProductBrandRequest pmsProductBrandRequest) {
        try {
            pmsProductBrandService.create(pmsProductBrandRequest);
            return ResponseEntity.ok("Create successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody PmsProductBrandRequest pmsProductBrandRequest) {
        try {
            int result = pmsProductBrandService.update(id, pmsProductBrandRequest);
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
            pmsProductBrandService.delete(id);
            return ResponseEntity.ok("Deleted successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        try {
            PmsProductBrand pmsProductBrand = pmsProductBrandService.get(id);
            return ResponseEntity.ok(pmsProductBrand);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<?> listAll() {
        try {
            List<PmsProductBrand> productBrandList = pmsProductBrandService.listAll();
            return ResponseEntity.ok(productBrandList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
