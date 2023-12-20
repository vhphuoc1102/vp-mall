package com.phuocvh.dto;

import com.phuocvh.entity.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductRegistrationParam {
    private PmsProductBrand pmsProductBrand;
    private List<PmsProductCategory> pmsProductCategory;
    private List<PmsProductAttributeAssociation> pmsProductAttributeAssociations;
    private List<PmsProductComment> pmsProductComments;
    private List<PmsProductService> pmsProductServices;
    private PmsProductFreight pmsProductFreight;
    private List<PmsProductPrice> pmsProductPrice;
}
