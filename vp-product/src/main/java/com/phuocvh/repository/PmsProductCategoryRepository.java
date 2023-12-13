package com.phuocvh.repository;

import com.phuocvh.entity.PmsProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PmsProductCategoryRepository extends JpaRepository<PmsProductCategory, UUID> {
}