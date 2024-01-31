package com.phuocvh.repository;

import com.phuocvh.entity.OmsOrderReturnApply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OmsOrderReturnApplyRepository extends JpaRepository<OmsOrderReturnApply, UUID> {
}