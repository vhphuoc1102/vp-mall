package com.phuocvh.service.Impl;

import com.phuocvh.entity.PmsProductBrand;
import com.phuocvh.repository.PmsProductBrandRepository;
import com.phuocvh.service.PmsProductBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PmsProductBrandServiceImpl implements PmsProductBrandService {
    @Autowired
    private PmsProductBrandRepository pmsProductBrandRepository;

    @Override
    public PmsProductBrand getBrand(String id) {
        Optional<PmsProductBrand> pmsProductBrandOptional = pmsProductBrandRepository.findById(UUID.fromString(id));
        return pmsProductBrandOptional.orElse(null);
    }
}
