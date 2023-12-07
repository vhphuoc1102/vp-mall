package com.phuocvh.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("pms_member_price")
public class PmsMemberPrice {
    @Id
    private UUID id;
    private UUID memberLevelId;
    private Double memberPrice;
    private String memberName;

    @CreatedDate
    private Instant createDate;
    @LastModifiedDate
    private Instant updateDate;
}
