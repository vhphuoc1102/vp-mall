package com.phuocvh.dto.pmsProductBrandDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PmsProductBrandRequest {
    private String name;
    private String firstLetter;
    private Integer factoryStatus;
    private Integer showStatus;
    private Integer productCount;
    private Integer productCommentCount;
    private String logo;
    private String bigPic;
    private String brandStory;
}
