package com.phuocvh.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
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
    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant lastModifiedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private UmsMember umsMember;

    @PrePersist
    private void prePersist() {
        this.status = 0;
    }
}