package com.phuocvh.repository;

import com.phuocvh.entity.PmsProductFlashSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface PmsProductFlashSaleRepository extends JpaRepository<PmsProductFlashSale, UUID> {
    @Query(value = "SELECT p from PmsProductFlashSale p WHERE p.validTo > :now AND p.validFrom <= :now")
    List<PmsProductFlashSale> getFlashSaleProducts(@Param("now") Instant now);
}