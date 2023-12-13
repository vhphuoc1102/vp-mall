package com.phuocvh.repository;

import com.phuocvh.entity.PmsProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PmsProductCommentRepository extends JpaRepository<PmsProductComment, UUID> {
}