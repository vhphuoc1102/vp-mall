package com.phuocvh.repository;

import com.phuocvh.entity.UmsMemberRecipientAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UmsMemberRecipientAddressRepository extends JpaRepository<UmsMemberRecipientAddress, UUID> {
}