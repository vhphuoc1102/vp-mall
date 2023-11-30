package com.phuocvh.repository;

import com.phuocvh.entity.UmsMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UmsMemberRepository extends JpaRepository<UmsMember, UUID> {
    
}