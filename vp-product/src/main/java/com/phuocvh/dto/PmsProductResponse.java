package com.phuocvh.dto;

import com.phuocvh.entity.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;


public class PmsProductResponse {
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
    private Instant createdDate;
    private Instant lastModifiedDate;
    private PmsProductBrand pmsProductBrand;
    private List<PmsProductCategory> pmsProductCategory;
    private List<PmsProductAttributeAssociation> pmsProductAttributeAssociations;
    private List<PmsProductComment> pmsProductComments;
    private List<PmsProductService> pmsProductServices;
    private List<PmsProductFreight> pmsProductFreight;
    private List<PmsProductPrice> pmsProductPrice;
}
