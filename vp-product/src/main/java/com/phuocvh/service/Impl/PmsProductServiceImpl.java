package com.phuocvh.service.Impl;

import com.phuocvh.dto.PmsProductRequest;
import com.phuocvh.dto.PmsProductResponse;
import com.phuocvh.entity.PmsProduct;
import com.phuocvh.entity.PmsProductBrand;
import com.phuocvh.repository.*;
import com.phuocvh.service.PmsProductService;
import com.phuocvh.util.ProductUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PmsProductServiceImpl implements PmsProductService {
    @Autowired
    PmsProductRepository pmsProductRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PmsProductBrandRepository pmsProductBrandRepository;
    @Autowired
    private PmsProductCategoryRepository pmsProductCategoryRepository;
    @Autowired
    private PmsProductAttributeAssociationRepository pmsProductAttributeAssociationRepository;
    @Autowired
    private PmsProductCommentRepository pmsProductCommentRepository;
    @Autowired
    private PmsProductServiceRepository pmsProductServiceRepository;
    @Autowired
    private PmsProductFreightRepository pmsProductFreightRepository;
    @Autowired
    private PmsProductPriceRepository pmsProductPriceRepository;

    @Override
    public void create(PmsProductRequest pmsProductRequest) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        PmsProduct pmsProduct = convertToEntity(pmsProductRequest);
        ProductUtil.findAndInsert(pmsProduct, pmsProductBrandRepository, PmsProduct.class.getMethod("setPmsProductBrand", PmsProductBrand.class), pmsProductRequest.getPmsProductBrand());
        ProductUtil.findAndInsert(pmsProduct, pmsProductCategoryRepository, PmsProduct.class.getMethod("setPmsProductCategory", List.class), pmsProductRequest.getPmsProductCategory());
        ProductUtil.findAndInsert(pmsProduct, pmsProductServiceRepository, PmsProduct.class.getMethod("setPmsProductServices", List.class), pmsProductRequest.getPmsProductServices());
        ProductUtil.findAndInsert(pmsProduct, pmsProductFreightRepository, PmsProduct.class.getMethod("setPmsProductFreight", List.class), pmsProductRequest.getPmsProductFreight());
        ProductUtil.findAndInsert(pmsProduct, pmsProductPriceRepository, PmsProduct.class.getMethod("setPmsProductPrice", List.class), pmsProductRequest.getPmsProductPrice());

        pmsProductRepository.save(pmsProduct);
    }

    @Override
    public int update(String id, PmsProductRequest pmsProductRequest) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int result = 0;
        Optional<PmsProduct> pmsProductOptional = pmsProductRepository.findById(UUID.fromString(id));
        if (pmsProductOptional.isPresent()) {
            PmsProduct pmsProduct = pmsProductOptional.get();

            ProductUtil.findAndInsert(pmsProduct, pmsProductBrandRepository, PmsProduct.class.getMethod("setPmsProductBrand", PmsProductBrand.class), pmsProductRequest.getPmsProductBrand());
            ProductUtil.findAndInsert(pmsProduct, pmsProductCategoryRepository, PmsProduct.class.getMethod("setPmsProductCategory", List.class), pmsProductRequest.getPmsProductCategory());
            ProductUtil.findAndInsert(pmsProduct, pmsProductServiceRepository, PmsProduct.class.getMethod("setPmsProductServices", List.class), pmsProductRequest.getPmsProductServices());
            ProductUtil.findAndInsert(pmsProduct, pmsProductFreightRepository, PmsProduct.class.getMethod("setPmsProductFreight", List.class), pmsProductRequest.getPmsProductFreight());
            ProductUtil.findAndInsert(pmsProduct, pmsProductPriceRepository, PmsProduct.class.getMethod("setPmsProductPrice", List.class), pmsProductRequest.getPmsProductPrice());

            convertToEntity(pmsProductRequest, pmsProduct);
            result = 1;
        }
        return result;
    }

    @Override
    public void delete(String id) {
        pmsProductRepository.deleteById(UUID.fromString(id));
    }

    @Override
    public List<PmsProduct> list() {
        List<PmsProduct> productList = pmsProductRepository.findAll();
        return productList;
    }

    private PmsProductResponse convertToResponse(PmsProduct product) {
        if (modelMapper.getTypeMap(PmsProduct.class, PmsProductResponse.class) == null) {
            TypeMap<PmsProduct, PmsProductResponse> propertyMapper = this.modelMapper.createTypeMap(PmsProduct.class, PmsProductResponse.class);

        }
        return null;
    }

    private void convertToEntity(PmsProductRequest pmsProductRequest, PmsProduct pmsProduct) {
        if (modelMapper.getTypeMap(PmsProduct.class, PmsProduct.class) == null) {
            TypeMap<PmsProduct, PmsProduct> propertyMapper = this.modelMapper.createTypeMap(PmsProduct.class, PmsProduct.class);
            Provider<PmsProduct> provider = p -> pmsProduct;
            propertyMapper.setProvider(provider);
        }
        PmsProduct newProduct = convertToEntity(pmsProductRequest);
        modelMapper.map(newProduct, PmsProduct.class);
    }

    private PmsProduct convertToEntity(PmsProductRequest pmsProductRequest) {
        if (modelMapper.getTypeMap(PmsProductRequest.class, PmsProduct.class) == null) {
            TypeMap<PmsProductRequest, PmsProduct> propertyMapper = this.modelMapper.createTypeMap(PmsProductRequest.class, PmsProduct.class);

            propertyMapper.addMappings(mapper -> mapper.skip(PmsProductRequest::getPmsProductBrand, PmsProduct::setPmsProductBrand));
            propertyMapper.addMappings(mapper -> mapper.skip(PmsProductRequest::getPmsProductCategory, PmsProduct::setPmsProductCategory));
            propertyMapper.addMappings(mapper -> mapper.skip(PmsProductRequest::getPmsProductServices, PmsProduct::setPmsProductServices));
            propertyMapper.addMappings(mapper -> mapper.skip(PmsProductRequest::getPmsProductPrice, PmsProduct::setPmsProductPrice));
            propertyMapper.addMappings(mapper -> mapper.skip(PmsProductRequest::getPmsProductFreight, PmsProduct::setPmsProductFreight));
            propertyMapper.addMappings(mapper -> mapper.skip(PmsProductRequest::getPmsProductAttributes, PmsProduct::setPmsProductAttributeAssociations));
        }

        return modelMapper.map(pmsProductRequest, PmsProduct.class);
    }
}
