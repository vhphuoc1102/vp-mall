package com.phuocvh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "oms_order")
@AllArgsConstructor
@NoArgsConstructor
public class OmsOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private UUID memberId;
    private String orderSn;

    private Integer status;
    private Integer payType;

    private Double totalAmount;
    private Double paymentAmount;
    private Double freightAmount;

    private String receiverName;
    private String receiverPhone;
    private String receiverProvince;
    private String receiverDistrict;
    private String receiverWard;
    private String receiverDetailAddress;
    private String note;

    @OneToMany(mappedBy = "omsOrder")
    private List<OmsOrderItem> omsOrderItems;

    @CreationTimestamp
    private Instant createdDate;
}
