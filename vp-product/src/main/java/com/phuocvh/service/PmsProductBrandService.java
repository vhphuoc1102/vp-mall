package com.phuocvh.service;

import com.phuocvh.dto.PmsProductBrandRequest;
import com.phuocvh.entity.PmsProductBrand;

import java.util.List;

public interface PmsProductBrandService {
    void create(PmsProductBrandRequest pmsProductBrandRequest);

    PmsProductBrand get(String id);

    int update(String id, PmsProductBrandRequest pmsProductBrandRequest);

    void delete(String id);

    List<PmsProductBrand> listAll();

}
