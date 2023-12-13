package com.phuocvh.repository;

import com.phuocvh.entity.PmsProductAlbumPicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PmsProductAlbumPictureRepository extends JpaRepository<PmsProductAlbumPicture, UUID> {
}