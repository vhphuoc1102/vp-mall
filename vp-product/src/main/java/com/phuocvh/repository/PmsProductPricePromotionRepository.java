package com.phuocvh.repository;

import com.phuocvh.entity.PmsProductPricePromotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PmsProductPricePromotionRepository extends JpaRepository<PmsProductPricePromotion, UUID> {
}