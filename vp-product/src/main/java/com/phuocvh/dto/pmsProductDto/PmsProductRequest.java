package com.phuocvh.dto.pmsProductDto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PmsProductRequest {
    private String name;
    private String title;
    private String subtitle;
    private String keywords;
    private String note;
    private String productSn;
    private Integer saleType;

    private String detailHTML;
    private String detailDesc;

    private Integer newStatus;

    private UUID pmsProductBrand;
    private List<UUID> pmsProductCategory;
    private List<UUID> pmsProductAttributes;
    private List<UUID> pmsProductServices;
    private List<UUID> pmsProductFreight;
    private List<UUID> pmsProductPrice;


    private MultipartFile picture;
}
