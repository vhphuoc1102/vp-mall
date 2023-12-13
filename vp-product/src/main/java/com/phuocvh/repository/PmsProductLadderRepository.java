package com.phuocvh.repository;

import com.phuocvh.entity.PmsProductLadder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PmsProductLadderRepository extends JpaRepository<PmsProductLadder, UUID> {
}