package com.phuocvh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "pms_product_price")
@AllArgsConstructor
public class PmsProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String productCode;
    private Double originalPrice;
    private Double price;

    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant lastModifiedDate;
    @JsonIgnoreProperties("pmsProductPrice")
    @ManyToOne(fetch = FetchType.LAZY)
    private PmsProduct pmsProduct;
}
