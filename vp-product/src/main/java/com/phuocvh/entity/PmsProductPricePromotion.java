package com.phuocvh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Builder
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pms_product_price_promotion")
@AllArgsConstructor
public class PmsProductPricePromotion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String productCode;
    private Double promotionPrice;

    private Instant promotionStart;
    private Instant promotionEnd;
}
