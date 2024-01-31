package com.phuocvh.service;

import com.phuocvh.dto.pmsProductDto.PmsProductQueryParam;
import com.phuocvh.dto.pmsProductDto.PmsProductRequest;
import com.phuocvh.entity.PmsProduct;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

public interface PmsProductService {
    void create(PmsProductRequest pmsProductRequest, MultipartFile picture) throws ParseException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    PmsProduct get(String id);

    int update(String id, PmsProductRequest pmsProductRequest) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    void delete(String id);

    List<PmsProduct> listAll();

    List<PmsProduct> list(PmsProductQueryParam pmsProductQueryParam, Integer pageSize, Integer pageNum);

}
