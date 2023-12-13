package com.phuocvh.repository;

import com.phuocvh.entity.PmsProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PmsProductRepository extends JpaRepository<PmsProduct, UUID> {
}