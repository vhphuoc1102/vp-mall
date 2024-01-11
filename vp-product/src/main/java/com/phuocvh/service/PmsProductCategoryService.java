package com.phuocvh.service;

import com.phuocvh.dto.pmsProductCategoryDto.PmsProductCategoryRequest;
import com.phuocvh.dto.pmsProductCategoryDto.PmsProductCategoryTree;
import com.phuocvh.entity.PmsProductCategory;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface PmsProductCategoryService {
    void create(PmsProductCategoryRequest pmsProductCategoryRequest) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    int update(String id, PmsProductCategoryRequest pmsProductCategoryRequest);

    void delete(String id);

    List<PmsProductCategory> listAll();

    PmsProductCategory get(String id);

    List<PmsProductCategoryTree> listTree();
}
