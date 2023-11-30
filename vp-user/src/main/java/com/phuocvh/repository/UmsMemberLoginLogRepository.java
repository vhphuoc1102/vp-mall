package com.phuocvh.repository;

import com.phuocvh.entity.UmsMemberLoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UmsMemberLoginLogRepository extends JpaRepository<UmsMemberLoginLog, UUID> {
}