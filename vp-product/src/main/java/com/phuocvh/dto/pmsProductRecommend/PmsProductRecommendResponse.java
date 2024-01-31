package com.phuocvh.dto.pmsProductRecommend;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PmsProductRecommendResponse {

    private Instant validFrom;
    private Instant validTo;
    private List<RecommendProductDetail> recommendProductDetailList = new ArrayList<>();

    @Setter
    @Getter
    public static class RecommendProductDetail {
        private UUID id;
        private String name;
        private String title;
        private String pic;
        private Double rating;
        private Integer reviews;
        private Integer sold;
        private Double price;
    }
}
