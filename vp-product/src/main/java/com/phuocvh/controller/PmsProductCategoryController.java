package com.phuocvh.controller;

import com.phuocvh.dto.pmsProductCategoryDto.PmsProductCategoryRequest;
import com.phuocvh.dto.pmsProductCategoryDto.PmsProductCategoryTree;
import com.phuocvh.entity.PmsProductCategory;
import com.phuocvh.service.PmsProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/category")
@CrossOrigin("http://localhost:3000")
public class PmsProductCategoryController {
    @Autowired
    private PmsProductCategoryService pmsProductCategoryService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody PmsProductCategoryRequest pmsProductCategoryRequest) {
        try {
            pmsProductCategoryService.create(pmsProductCategoryRequest);
            return ResponseEntity.ok("Create successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable String id, @RequestBody PmsProductCategoryRequest pmsProductCategoryRequest) {
        try {
            int result = pmsProductCategoryService.update(id, pmsProductCategoryRequest);
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
            pmsProductCategoryService.delete(id);
            return ResponseEntity.ok("Deleted successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        try {
            PmsProductCategory pmsProductCategory = pmsProductCategoryService.get(id);
            return ResponseEntity.ok(pmsProductCategory);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/listAll")
    public ResponseEntity<?> listAll() {
        try {
            List<PmsProductCategory> productCategoryList = pmsProductCategoryService.listAll();
            return ResponseEntity.ok(productCategoryList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/listTree")
    public ResponseEntity<?> getCategoryTree() {
        try {
            List<PmsProductCategoryTree> pmsProductCategoryTrees = pmsProductCategoryService.listTree();
            return ResponseEntity.ok(pmsProductCategoryTrees);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
