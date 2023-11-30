package com.phuocvh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "ums_member_recipient_address")
public class UmsMemberRecipientAddress {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String phone;
    @ColumnDefault("0")
    private Integer status;
    private String postCode;
    @NotNull
    private String province;
    @NotNull
    private String city;
    @NotNull
    private String region;
    @NotNull
    private String detailAddress;
}