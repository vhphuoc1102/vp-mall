package com.phuocvh.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "ums_member_level")
public class UmsMemberLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @NotBlank
    private String name;
    private Integer growthPoint;
    private Double freeFreightPoint;
    private Integer commentGrowthPoint;
    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant lastModifiedDate;

    @PrePersist
    private void prePersist() {
        this.growthPoint = 0;
        this.freeFreightPoint = 0D;
        this.commentGrowthPoint = 0;
    }

    @PreUpdate
    private void preUpdate() {
    }
}