package com.phuocvh.repository;

import com.phuocvh.entity.OmsOrderSetting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OmsOrderSettingRepository extends JpaRepository<OmsOrderSetting, UUID> {
}