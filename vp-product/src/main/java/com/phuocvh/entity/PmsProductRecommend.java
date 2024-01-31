package com.phuocvh.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Builder
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pms_product_recommend")
@AllArgsConstructor
public class PmsProductRecommend {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private Instant validFrom;
    private Instant validTo;

    @OneToOne(fetch = FetchType.LAZY)
    private PmsProduct pmsProduct;

    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant lastModifiedDate;
}
