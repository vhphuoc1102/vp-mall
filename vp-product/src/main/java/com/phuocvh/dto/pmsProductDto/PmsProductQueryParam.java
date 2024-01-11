package com.phuocvh.dto.pmsProductDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PmsProductQueryParam {
    private Integer deleteStatus;
    private Integer publishStatus;
    private Integer newStatus;
    private Integer recommendStatus;
    private Integer verifyStatus;
    private Integer previewStatus;
}
