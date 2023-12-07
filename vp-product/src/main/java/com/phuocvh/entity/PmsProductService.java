package com.phuocvh.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("pms_product_service")
public class PmsProductService {
    @Id
    private UUID id;
    private Integer code;
    private String name;
    private String icon;
}
