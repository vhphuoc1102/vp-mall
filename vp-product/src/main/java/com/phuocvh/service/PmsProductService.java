package com.phuocvh.service;

import com.phuocvh.entity.PmsProduct;

import java.util.List;

public interface PmsProductService {
    void registerProduct(PmsProduct pmsProductRegistrationParam);

    void updateProduct();

    void deleteProduct();

    List<PmsProduct> retrieveProducts();
}
