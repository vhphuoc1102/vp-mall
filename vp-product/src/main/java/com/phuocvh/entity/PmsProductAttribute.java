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
@Table(name = "pms_product_attribute")
@AllArgsConstructor
public class PmsProductAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String name;
    private Integer selectType;
    private Integer inputType;
    private Integer inputList;
    private Integer filterType;
    private Integer searchType;
    private Integer handAddStatus;
    private Integer type;

    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant lastModifiedDate;

    @ManyToMany(mappedBy = "pmsProductAttributes")
    private List<PmsProductCategory> pmsProductCategories;

    @OneToMany(mappedBy = "pmsProductAttribute", fetch = FetchType.LAZY)
    private List<PmsProductAttributeAssociation> pmsProductAttributeAssociations;
}
