package com.phuocvh.repository;

import com.phuocvh.entity.PmsProductService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PmsProductServiceRepository extends JpaRepository<PmsProductService, UUID> {
}