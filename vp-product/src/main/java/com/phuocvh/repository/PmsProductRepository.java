package com.phuocvh.repository;

import com.phuocvh.entity.PmsProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PmsProductRepository extends MongoRepository<PmsProduct, UUID> {
}
