package com.phuocvh.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("pms_product_category")
public class PmsProductCategory {
    @Id
    private UUID id;
    @NotBlank
    private String name;
    private Integer level;
    private Integer productCount;
    private Integer navStatus;
    private Integer showStatus;
    private String icon;
    private List<String> keywords;
    private String description;

    @DBRef
    @Field("product_attribute_ids")
    private List<PmsProductAttribute> productAttributes;
    @DBRef
    @Field("parent_category_id")
    private PmsProductCategory parentCategory;
}
