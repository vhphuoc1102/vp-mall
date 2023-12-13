package com.phuocvh.repository;

import com.phuocvh.entity.PmsProductAttributeAssociation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PmsProductAttributeAssociationRepository extends JpaRepository<PmsProductAttributeAssociation, UUID> {
}