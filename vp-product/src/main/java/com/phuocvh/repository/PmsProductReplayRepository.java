package com.phuocvh.repository;

import com.phuocvh.entity.PmsProductReplay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PmsProductReplayRepository extends JpaRepository<PmsProductReplay, UUID> {
}