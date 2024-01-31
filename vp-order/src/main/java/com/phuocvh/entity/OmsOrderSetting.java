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
@Table(name = "oms_order_setting")
@AllArgsConstructor
@NoArgsConstructor
public class OmsOrderSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    // If not confirm, after amount of day, the order will be marked as completed
    private Integer confirmOvertime;
    // Can only comment of after some days.
    private Integer commentOvertime;
    // Auto complete after some days and service like return or support will be invalid
    private Integer finishOvertime;

    @OneToOne
    private OmsOrder omsOrder;
}
