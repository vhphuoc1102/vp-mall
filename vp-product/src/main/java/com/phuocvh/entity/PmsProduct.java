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
@Table(name = "pms_product")
@AllArgsConstructor
public class PmsProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String name;
    private String title;
    private String subtitle;
    private String pic;
    private String keywords;
    private String note;

    private Integer deleteStatus;
    private Integer publishStatus;
    private Integer newStatus;
    private Integer recommendStatus;
    private Integer verifyStatus;
    private Integer previewStatus;

    private Integer saleType;

    private String detailHTML;
    private String detailDesc;

    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant lastModifiedDate;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private PmsProductBrand pmsProductBrand;
    @ManyToMany
    @JoinTable(name = "product_category_association")
    private List<PmsProductCategory> pmsProductCategory;
    @OneToMany(mappedBy = "pmsProduct", fetch = FetchType.LAZY)
    private List<PmsProductAttributeAssociation> pmsProductAttributeAssociations;
    @OneToMany(mappedBy = "pmsProduct")
    private List<PmsProductComment> pmsProductComments;
    @ManyToMany
    @JoinTable(name = "pms_product_service_association")
    private List<PmsProductService> pmsProductServices;
    @OneToMany(mappedBy = "pmsProduct")
    private List<PmsProductFreight> pmsProductFreight;
    @OneToMany(mappedBy = "pmsProduct")
    private List<PmsProductPrice> pmsProductPrice;
}
