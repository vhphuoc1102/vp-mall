package com.phuocvh.repository;

import com.phuocvh.entity.PmsProductRecommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface PmsProductRecommendRepository extends JpaRepository<PmsProductRecommend, UUID> {
    @Query(value = "SELECT p from PmsProductRecommend p WHERE p.validTo > :now AND p.validFrom <= :now")
    List<PmsProductRecommend> getCurrentRecommendProducts(@Param("now") Instant now);
}