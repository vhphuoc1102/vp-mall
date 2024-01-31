package com.phuocvh.dto.pmsProductFlashSale;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PmsProductFlashSaleRequest {
    private Instant validFrom;
    private Instant validTo;
    private List<FlashSaleProduct> flashSaleProducts;

    @Getter
    @Setter
    public static class FlashSaleProduct {
        private UUID id;
        private Double salePercentage;
    }
}
