package com.phuocvh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pms_product_replay")
@AllArgsConstructor
public class PmsProductReplay {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String memberNickName;
    private String memberIcon;
    private String content;
    private String type;
    @ManyToOne(fetch = FetchType.LAZY)
    private PmsProductComment pmsProductComment;
}
