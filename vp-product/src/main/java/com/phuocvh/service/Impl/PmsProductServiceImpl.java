package com.phuocvh.service.Impl;

import com.phuocvh.entity.PmsProduct;
import com.phuocvh.repository.PmsProductRepository;
import com.phuocvh.service.PmsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PmsProductServiceImpl implements PmsProductService {
    @Autowired
    PmsProductRepository pmsProductRepository;

    @Override
    public void registerProduct(PmsProduct pmsProductParam) {
        pmsProductRepository.save(pmsProductParam);
    }


    @Override
    public void updateProduct() {

    }

    @Override
    public void deleteProduct() {

    }

    @Override
    public List<PmsProduct> retrieveProducts() {
        return null;
    }

    public void relateAndInsertList(Object dao, List dataList, UUID id) {

    }
}
