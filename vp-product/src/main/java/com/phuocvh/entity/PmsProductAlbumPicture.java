package com.phuocvh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pms_product_album_picture")
@AllArgsConstructor
public class PmsProductAlbumPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String pic;
    @ManyToOne(fetch = FetchType.LAZY)
    private PmsProductAlbum pmsProductAlbum;
}
