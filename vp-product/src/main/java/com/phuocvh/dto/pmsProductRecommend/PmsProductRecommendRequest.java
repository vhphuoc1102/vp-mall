package com.phuocvh.dto.pmsProductRecommend;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class PmsProductRecommendRequest {
    private Instant validFrom;
    private Instant validTo;
    private List<UUID> pmsProducts;
}
