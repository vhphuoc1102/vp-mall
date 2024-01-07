package com.phuocvh.service;

import com.phuocvh.entity.PmsProductCategory;

import java.util.List;

public interface PmsProductCategoryService {
    PmsProductCategory create(PmsProductCategory pmsProductCategory);

    int update(String id, PmsProductCategory pmsProductCategory);

    void delete(PmsProductCategory pmsProductCategory);

    List<PmsProductCategory> listAll();

    PmsProductCategory get(String id);
}
