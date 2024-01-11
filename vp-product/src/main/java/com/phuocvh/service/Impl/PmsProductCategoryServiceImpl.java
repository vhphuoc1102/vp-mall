package com.phuocvh.service.Impl;

import com.phuocvh.dto.pmsProductCategoryDto.PmsProductCategoryRequest;
import com.phuocvh.dto.pmsProductCategoryDto.PmsProductCategoryTree;
import com.phuocvh.entity.PmsProduct;
import com.phuocvh.entity.PmsProductCategory;
import com.phuocvh.repository.PmsProductCategoryRepository;
import com.phuocvh.service.PmsProductCategoryService;
import com.phuocvh.util.ProductUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.modelmapper.TypeMap;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PmsProductCategoryServiceImpl implements PmsProductCategoryService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PmsProductCategoryRepository pmsProductCategoryRepository;
    @Autowired
    private EntityManager entityManager;

    @Override
    public void create(PmsProductCategoryRequest pmsProductCategoryRequest) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        PmsProductCategory pmsProductCategory = convertToEntity(pmsProductCategoryRequest);

        ProductUtil.findAndInsert(pmsProductCategory, pmsProductCategoryRepository, PmsProductCategory.class.getMethod("setChildrenCategories", List.class), pmsProductCategoryRequest.getChildrenCategories());
        ProductUtil.findAndInsert(pmsProductCategory, pmsProductCategoryRepository, PmsProductCategory.class.getMethod("setPmsProductAttributes", List.class), pmsProductCategoryRequest.getPmsProductAttributes());
        ProductUtil.findAndInsert(pmsProductCategory, pmsProductCategoryRepository, PmsProductCategory.class.getMethod("setParentCategory", PmsProductCategory.class), pmsProductCategoryRequest.getParentCategory());

        pmsProductCategoryRepository.save(pmsProductCategory);
    }

    @Override
    public int update(String id, PmsProductCategoryRequest pmsProductCategoryRequest) {
        int result = 0;
        Optional<PmsProductCategory> pmsProductCategoryOptionalOptional = pmsProductCategoryRepository.findById(UUID.fromString(id));
        if (pmsProductCategoryOptionalOptional.isPresent()) {
            PmsProductCategory pmsProductCategory = pmsProductCategoryOptionalOptional.get();
            convertToEntity(pmsProductCategoryRequest, pmsProductCategory);
            pmsProductCategoryRepository.save(pmsProductCategory);
            result = 1;
        }
        return result;
    }

    @Override
    public void delete(String id) {
        pmsProductCategoryRepository.deleteById(UUID.fromString(id));
    }

    @Override
    public List<PmsProductCategory> listAll() {
        return pmsProductCategoryRepository.findAll();
    }

    @Override
    public PmsProductCategory get(String id) {
        Optional<PmsProductCategory> pmsProductCategoryOptional = pmsProductCategoryRepository.findById(UUID.fromString(id));
        return pmsProductCategoryOptional.orElse(null);
    }

    @Override
    public List<PmsProductCategoryTree> listTree() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<PmsProductCategory> criteria = builder.createQuery(PmsProductCategory.class);
        Root<PmsProductCategory> root = criteria.from(PmsProductCategory.class);
        criteria.select(root).where(builder.isNull(root.get("parentCategory")));
        List<PmsProductCategory> pmsProductCategories = entityManager.createQuery(criteria).getResultList();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setPreferNestedProperties(false);
        return convertToCategoryTree(pmsProductCategories);
    }

    public List<PmsProductCategoryTree> convertToCategoryTree(List<PmsProductCategory> pmsProductCategories) {
        List<PmsProductCategoryTree> pmsProductCategoryTrees = new ArrayList<>();
        for (PmsProductCategory pmsProductCategory : pmsProductCategories) {
            PmsProductCategoryTree pmsProductCategoryTree = modelMapper.map(pmsProductCategory, PmsProductCategoryTree.class);
            List<PmsProductCategoryTree> pmsProductCategoryTreeChildren;
            if (!pmsProductCategory.getChildrenCategories().isEmpty()) {
                pmsProductCategoryTreeChildren = convertToCategoryTree(pmsProductCategory.getChildrenCategories());
                pmsProductCategoryTree.setPmsProductCategoryTrees(pmsProductCategoryTreeChildren);
            }
            pmsProductCategoryTrees.add(pmsProductCategoryTree);
        }
        return pmsProductCategoryTrees;
    }

    private void convertToEntity(PmsProductCategoryRequest pmsProductCategoryRequest, PmsProductCategory pmsProductCategory) {
        if (modelMapper.getTypeMap(PmsProductCategory.class, PmsProductCategory.class) == null) {
            TypeMap<PmsProductCategory, PmsProductCategory> propertyMapper = this.modelMapper.createTypeMap(PmsProductCategory.class, PmsProductCategory.class);
            Provider<PmsProductCategory> provider = p -> pmsProductCategory;
            propertyMapper.setProvider(provider);
            this.modelMapper.getConfiguration().setSkipNullEnabled(true);
        }
        PmsProductCategory newPmsProductCategory = convertToEntity(pmsProductCategoryRequest);
        modelMapper.map(newPmsProductCategory, PmsProduct.class);
    }

    private PmsProductCategory convertToEntity(PmsProductCategoryRequest pmsProductCategoryRequest) {
        if (modelMapper.getTypeMap(PmsProductCategoryRequest.class, PmsProductCategory.class) == null) {
            TypeMap<PmsProductCategoryRequest, PmsProductCategory> propertyMapper = this.modelMapper.createTypeMap(PmsProductCategoryRequest.class, PmsProductCategory.class);
//            propertyMapper.addMappings(mapper -> mapper.skip(PmsProductCategoryRequest::getPmsProductAttributes, PmsProductCategory::setPmsProductAttributes));
            this.modelMapper.getConfiguration().setSkipNullEnabled(true);
        }

        return modelMapper.map(pmsProductCategoryRequest, PmsProductCategory.class);
    }
}
