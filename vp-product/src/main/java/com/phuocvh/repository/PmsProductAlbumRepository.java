package com.phuocvh.repository;

import com.phuocvh.entity.PmsProductAlbum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PmsProductAlbumRepository extends JpaRepository<PmsProductAlbum, UUID> {
}