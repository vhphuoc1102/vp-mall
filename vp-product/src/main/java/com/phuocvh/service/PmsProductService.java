package com.phuocvh.service;

import com.phuocvh.dto.PmsProductQueryParam;
import com.phuocvh.dto.PmsProductRequest;
import com.phuocvh.entity.PmsProduct;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

public interface PmsProductService {
    void create(PmsProductRequest pmsProductRequest) throws ParseException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    PmsProduct get(String id);

    int update(String id, PmsProductRequest pmsProductRequest) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    void delete(String id);

    List<PmsProduct> listAll();

    List<PmsProduct> list(PmsProductQueryParam pmsProductQueryParam, Integer pageSize, Integer pageNum);
}
