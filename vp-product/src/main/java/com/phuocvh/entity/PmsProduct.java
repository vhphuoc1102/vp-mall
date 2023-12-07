package com.phuocvh.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("pms_product")
public class PmsProduct {
    @Id
    private UUID id;
    private String name;
    private String title;
    private String subtitle;
    private String pic;

    private Integer deleteStatus;
    private Integer publishStatus;
    private Integer newStatus;
    private Integer verifyStatus;
    private Integer previewStatus;

    private Double price;
    private Double promotionPrice;
    private Double originalPrice;
    private Double weight;
    private List<String> keywords;
    private String description;
    private String note;

    @CreatedDate
    private Instant createDate;
    @LastModifiedDate
    private Instant updateDate;

    @DBRef
    @Field("brand_id")
    private PmsProductBrand pmsProductBrand;
    @DBRef
    @Field("service_ids")
    private List<PmsProductService> pmsProductServices;
}
