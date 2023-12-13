package com.phuocvh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pms_product_album")
@AllArgsConstructor
public class PmsProductAlbum {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String name;
    private String coverPic;
    private String picCount;
    private String description;

    @OneToMany(mappedBy = "pmsProductAlbum")
    private List<PmsProductAlbumPicture> pmsProductAlbumPictures;
}
