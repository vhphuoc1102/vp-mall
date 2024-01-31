package com.phuocvh.service;

import com.phuocvh.dto.pmsProductRecommend.PmsProductRecommendRequest;
import com.phuocvh.dto.pmsProductRecommend.PmsProductRecommendResponse;
import com.phuocvh.entity.PmsProductRecommend;

import java.util.List;

public interface PmsProductRecommendService {
    void create(PmsProductRecommendRequest pmsProductRecommendRequest);

    PmsProductRecommend get(String id);

    int update(String id, PmsProductRecommendRequest pmsProductRecommendRequest);

    void delete(String id);

    List<PmsProductRecommend> listAll();

    PmsProductRecommendResponse getCurrentRecommendProducts();
}
