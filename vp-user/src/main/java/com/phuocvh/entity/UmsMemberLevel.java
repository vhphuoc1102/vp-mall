package com.phuocvh.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
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
    @ColumnDefault("0")
    private Integer growthPoint;
    @ColumnDefault("0")
    private Double freeFreightPoint;
    @ColumnDefault("0")
    private Integer commentGrowthPoint;
    @CreationTimestamp
    private Instant createdTime;
    @UpdateTimestamp
    private Instant updatedTime;

//    @OneToOne(mappedBy = "umsMemberLevel")
//    private UmsMember umsMember;
}