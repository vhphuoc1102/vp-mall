package com.phuocvh.service;

import com.phuocvh.entity.PmsProductCategory;

import java.util.List;

public interface PmsProductCategoryService {
    PmsProductCategory registerCategory(PmsProductCategory pmsProductCategory);

    void updateCategory(PmsProductCategory pmsProductCategory);

    void deleteCategory(PmsProductCategory pmsProductCategory);

    List<PmsProductCategory> retrieveCategories();
}
