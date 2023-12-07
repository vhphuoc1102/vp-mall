package com.phuocvh.entity;

import jakarta.validation.constraints.NotBlank;
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
@Document("pms_product_brand")
public class PmsProductBrand {
    @Id
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String firstLetter;
    @NotBlank
    private Integer factoryStatus; // Tinh trang hang
    @NotBlank
    private Integer showStatus; // Tinh trang show
    @NotBlank
    private Integer productCount; // So luong san pham
    @NotBlank
    private String brand_story; // Gioi thieu ve brand
    @NotBlank
    private String icon;
    @NotBlank
    private String smallPic;
    @NotBlank
    private String bigPic;
    private String description;
    private Instant createdTime;
    private Instant updatedTime;
    @CreatedDate
    private Instant createDate;
    @LastModifiedDate
    private Instant updateDate;

    @DBRef
    @Field("product_ids")
    private List<PmsProduct> pmsProducts;
}
