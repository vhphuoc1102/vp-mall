package com.phuocvh.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "pms_product")
@AllArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
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
    //    @JsonManagedReference
//    @JsonBackReference
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnoreProperties({"pmsProducts", "hibernateLazyInitializer"})
    @ManyToOne(fetch = FetchType.LAZY)
    private PmsProductBrand pmsProductBrand;
    @ManyToMany(mappedBy = "pmsProducts", fetch = FetchType.LAZY)
    private List<PmsProductCategory> pmsProductCategory = new ArrayList<>();
    @OneToMany(mappedBy = "pmsProduct")
    private List<PmsProductAttributeAssociation> pmsProductAttributeAssociations = new ArrayList<>();
    @OneToMany(mappedBy = "pmsProduct")
    private List<PmsProductComment> pmsProductComments = new ArrayList<>();
    @ManyToMany(mappedBy = "pmsProducts")
    private List<PmsProductService> pmsProductServices = new ArrayList<>();
    @OneToMany(mappedBy = "pmsProduct")
    private List<PmsProductFreight> pmsProductFreight = new ArrayList<>();
    @OneToMany(mappedBy = "pmsProduct")
    private List<PmsProductPrice> pmsProductPrice = new ArrayList<>();

    public PmsProduct() {
        super();
    }

    @PrePersist
    private void prePersist() {
        this.deleteStatus = 0;
        this.publishStatus = 0;
        this.recommendStatus = 0;
        this.verifyStatus = 0;
        this.previewStatus = 0;
    }
}
