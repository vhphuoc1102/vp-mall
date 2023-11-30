package com.phuocvh.repository;

import com.phuocvh.entity.UmsMemberLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UmsMemberLevelRepository extends JpaRepository<UmsMemberLevel, UUID> {
}