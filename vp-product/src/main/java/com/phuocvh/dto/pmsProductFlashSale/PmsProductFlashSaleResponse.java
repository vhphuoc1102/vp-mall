package com.phuocvh.dto.pmsProductFlashSale;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class PmsProductFlashSaleResponse {
    private Instant validFrom;
    private Instant validTo;
    private List<FlashSaleProductDetail> flashSaleProductDetailList = new ArrayList<>();

    @Setter
    @Getter
    public static class FlashSaleProductDetail {
        private UUID id;
        private String name;
        private String title;
        private String pic;
        private Double rating;
        private Integer reviews;
        private Integer sold;
        private Double salePercentage;
        private Double price;
        private Double priceAfterSale;
    }
}
