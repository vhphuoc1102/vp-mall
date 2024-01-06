package com.phuocvh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Builder
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pms_product_service")
@AllArgsConstructor
public class PmsProductService {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String name;
    private String icons;
    private String description;

    @ManyToMany
    @JoinTable(name = "pms_product_service_association")
    private List<PmsProduct> pmsProducts;
}
