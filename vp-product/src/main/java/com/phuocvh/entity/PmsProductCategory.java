package com.phuocvh.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Builder
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pms_product_category")
@AllArgsConstructor
public class PmsProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String name;
    private Integer level;
    private Integer productCount;
    private Integer navStatus;
    private Integer showStatus;
    private String icon;
    private String keywords;
    private String description;

    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant lastModifiedDate;

    @OneToOne(fetch = FetchType.LAZY)
    private PmsProductCategory parentCategory;

    @ManyToMany
    @JoinTable(name = "pms_product_category_association")
    private List<PmsProduct> pmsProducts;
    @ManyToMany
    @JoinTable(name = "product_category_attribute_association")
    private List<PmsProductAttribute> pmsProductAttributes;
}
