package com.phuocvh.service;

import com.phuocvh.dto.pmsProductFlashSale.PmsProductFlashSaleRequest;
import com.phuocvh.dto.pmsProductFlashSale.PmsProductFlashSaleResponse;
import com.phuocvh.entity.PmsProductFlashSale;

public interface PmsProductFlashSaleService {
    void create(PmsProductFlashSaleRequest pmsProductFlashSaleRequest);

    PmsProductFlashSale get(String id);

    int update(String id, PmsProductFlashSaleRequest pmsProductFlashSaleRequest);

    void delete(String id);

    PmsProductFlashSaleResponse getCurrentFlashSaleProducts();
}
