package com.phuocvh.service.Impl;

import com.phuocvh.dto.pmsProductRecommend.PmsProductRecommendRequest;
import com.phuocvh.dto.pmsProductRecommend.PmsProductRecommendResponse;
import com.phuocvh.entity.PmsProduct;
import com.phuocvh.entity.PmsProductPrice;
import com.phuocvh.entity.PmsProductRecommend;
import com.phuocvh.repository.PmsProductRecommendRepository;
import com.phuocvh.repository.PmsProductRepository;
import com.phuocvh.service.PmsProductRecommendService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
public class PmsProductRecommendServiceImpl implements PmsProductRecommendService {
    @Autowired
    private PmsProductRecommendRepository pmsProductRecommendRepository;
    @Autowired
    private PmsProductRepository pmsProductRepository;

    private static PmsProductRecommendResponse.RecommendProductDetail getPmsProductRecommendDetail(PmsProductRecommend pmsProductRecommend) {
        PmsProduct pmsProduct = pmsProductRecommend.getPmsProduct();
        List<PmsProductPrice> pmsProductPrices = pmsProduct.getPmsProductPrice();
        if (pmsProductPrices.isEmpty())
            throw new EntityNotFoundException("Not exist product price with product id: " + pmsProduct.getId());

        PmsProductRecommendResponse.RecommendProductDetail recommendProductDetail = new PmsProductRecommendResponse.RecommendProductDetail();
        recommendProductDetail.setId(pmsProduct.getId());
        recommendProductDetail.setTitle(pmsProduct.getTitle());
        recommendProductDetail.setName(pmsProduct.getName());
        recommendProductDetail.setPic(pmsProduct.getPic());
        recommendProductDetail.setRating(pmsProduct.getRating());
        recommendProductDetail.setReviews(pmsProduct.getReviewNumber());
        recommendProductDetail.setSold(pmsProduct.getSoldNumber());

        pmsProductPrices.sort(Comparator.comparing(PmsProductPrice::getPrice));
        recommendProductDetail.setPrice(pmsProductPrices.get(0).getPrice());
        return recommendProductDetail;
    }

    @Override
    public void create(PmsProductRecommendRequest pmsProductRecommendRequest) {
        List<UUID> idList = pmsProductRecommendRequest.getPmsProducts();
        List<PmsProduct> pmsProducts = pmsProductRepository.findAllById(idList);
        List<PmsProductRecommend> pmsProductRecommends = new ArrayList<>();
        for (PmsProduct pmsProduct : pmsProducts) {
            PmsProductRecommend pmsProductRecommend = new PmsProductRecommend();
            pmsProductRecommend.setPmsProduct(pmsProduct);
            pmsProductRecommend.setValidFrom(pmsProductRecommendRequest.getValidFrom());
            pmsProductRecommend.setValidTo(pmsProductRecommendRequest.getValidTo());
            pmsProductRecommends.add(pmsProductRecommend);
        }
        pmsProductRecommendRepository.saveAll(pmsProductRecommends);
    }

    @Override
    public PmsProductRecommend get(String id) {
        return null;
    }

    @Override
    public int update(String id, PmsProductRecommendRequest pmsProductRecommendRequest) {
        return 0;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<PmsProductRecommend> listAll() {
        return null;
    }

    @Override
    public PmsProductRecommendResponse getCurrentRecommendProducts() {
        Instant now = Instant.now();
        List<PmsProductRecommend> pmsProductRecommendList = pmsProductRecommendRepository.getCurrentRecommendProducts(now);
        if (pmsProductRecommendList.isEmpty()) return null;
        PmsProductRecommendResponse response = new PmsProductRecommendResponse();
        response.setValidFrom(pmsProductRecommendList.get(0).getValidFrom());
        response.setValidTo(pmsProductRecommendList.get(0).getValidTo());
        for (PmsProductRecommend pmsProductRecommend : pmsProductRecommendList) {
            PmsProductRecommendResponse.RecommendProductDetail recommendProductDetail = getPmsProductRecommendDetail(pmsProductRecommend);
            response.getRecommendProductDetailList().add(recommendProductDetail);
        }
        return response;
    }
}
