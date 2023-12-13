package com.phuocvh.repository;

import com.phuocvh.entity.PmsProductBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PmsProductBrandRepository extends JpaRepository<PmsProductBrand, UUID> {
}