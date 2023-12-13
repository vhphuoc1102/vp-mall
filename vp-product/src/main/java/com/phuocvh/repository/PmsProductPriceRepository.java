package com.phuocvh.repository;

import com.phuocvh.entity.PmsProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PmsProductPriceRepository extends JpaRepository<PmsProductPrice, UUID> {
}