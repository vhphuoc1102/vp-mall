package com.phuocvh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "oms_order_return_apply")
@AllArgsConstructor
@NoArgsConstructor
public class OmsOrderReturnApply {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String reason;
    private String description;
    private String proccessTime;
    private Integer status;

    @OneToOne(fetch = FetchType.LAZY)
    private OmsOrderItem omsOrderItem;
}
