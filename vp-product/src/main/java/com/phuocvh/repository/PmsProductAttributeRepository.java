package com.phuocvh.repository;

import com.phuocvh.entity.PmsProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PmsProductAttributeRepository extends JpaRepository<PmsProductAttribute, UUID> {
}