package com.phuocvh.repository;

import com.phuocvh.entity.OmsCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OmsCartRepository extends JpaRepository<OmsCart, UUID> {
}