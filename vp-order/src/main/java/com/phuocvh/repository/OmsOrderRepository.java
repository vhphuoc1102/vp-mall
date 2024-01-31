package com.phuocvh.repository;

import com.phuocvh.entity.OmsOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OmsOrderRepository extends JpaRepository<OmsOrder, UUID> {
}