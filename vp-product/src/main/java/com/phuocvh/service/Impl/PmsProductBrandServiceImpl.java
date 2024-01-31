package com.phuocvh.service.Impl;

import com.phuocvh.dto.PmsProductBrandRequest;
import com.phuocvh.entity.PmsProduct;
import com.phuocvh.entity.PmsProductBrand;
import com.phuocvh.repository.PmsProductBrandRepository;
import com.phuocvh.service.PmsProductBrandService;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PmsProductBrandServiceImpl implements PmsProductBrandService {
    @Autowired
    private PmsProductBrandRepository pmsProductBrandRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void create(PmsProductBrandRequest pmsProductBrandRequest) {
        PmsProductBrand pmsProductBrand = convertToEntity(pmsProductBrandRequest);
        pmsProductBrandRepository.save(pmsProductBrand);
    }

    @Override
    public PmsProductBrand get(String id) {
        Optional<PmsProductBrand> pmsProductBrandOptional = pmsProductBrandRepository.findById(UUID.fromString(id));
        return pmsProductBrandOptional.orElse(null);
    }


    @Override
    public int update(String id, PmsProductBrandRequest pmsProductBrandRequest) {
        int result = 0;
        Optional<PmsProductBrand> pmsProductBrandOptional = pmsProductBrandRepository.findById(UUID.fromString(id));
        if (pmsProductBrandOptional.isPresent()) {
            PmsProductBrand pmsProductBrand = pmsProductBrandOptional.get();
            convertToEntity(pmsProductBrandRequest, pmsProductBrand);
            result = 1;
        }
        return result;
    }

    @Override
    public void delete(String id) {
        pmsProductBrandRepository.deleteById(UUID.fromString(id));
    }

    @Override
    public List<PmsProductBrand> listAll() {
        return pmsProductBrandRepository.findAll();
    }

    private void convertToEntity(PmsProductBrandRequest pmsProductBrandRequest, PmsProductBrand pmsProductBrand) {
        if (modelMapper.getTypeMap(PmsProductBrand.class, PmsProductBrand.class) == null) {
            TypeMap<PmsProductBrand, PmsProductBrand> propertyMapper = this.modelMapper.createTypeMap(PmsProductBrand.class, PmsProductBrand.class);
            Provider<PmsProductBrand> provider = p -> pmsProductBrand;
            propertyMapper.setProvider(provider);
            this.modelMapper.getConfiguration().setSkipNullEnabled(true);
        }
        PmsProductBrand newPmsProductBrand = convertToEntity(pmsProductBrandRequest);
        modelMapper.map(newPmsProductBrand, PmsProduct.class);
    }

    private PmsProductBrand convertToEntity(PmsProductBrandRequest pmsProductBrandRequest) {
        if (modelMapper.getTypeMap(PmsProductBrandRequest.class, PmsProductBrand.class) == null) {
            TypeMap<PmsProductBrandRequest, PmsProductBrand> propertyMapper = this.modelMapper.createTypeMap(PmsProductBrandRequest.class, PmsProductBrand.class);
            this.modelMapper.getConfiguration().setSkipNullEnabled(true);
        }

        return modelMapper.map(pmsProductBrandRequest, PmsProductBrand.class);
    }
}
