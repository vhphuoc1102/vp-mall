package com.phuocvh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "oms_cart")
@AllArgsConstructor
@NoArgsConstructor
public class OmsCart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private UUID memberId;

    private UUID productId;
    private String productName;
    private String productBrand;
    private String productSn;
    private String productSubtitle;

    private UUID categoryId;
    private UUID brandId;

    private Double unitPrice;
    private Double quantity;
    private Double price;
    private String attribute;

    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant lastModifiedDate;
}
