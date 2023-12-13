package com.phuocvh.repository;

import com.phuocvh.entity.PmsProductFreight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PmsProductFreightRepository extends JpaRepository<PmsProductFreight, UUID> {
}