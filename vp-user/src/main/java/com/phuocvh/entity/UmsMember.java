package com.phuocvh.entity;


import com.google.common.hash.Hashing;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Builder
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(
        name = "ums_member",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "email"})}
)
@AllArgsConstructor
public class UmsMember {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String nickname;
    private String phone;
    private String email;
    private Integer status = 1;
    private String icon;
    private String gender;
    private String birthday;
    @CreationTimestamp
    private Instant createdDate;
    @UpdateTimestamp
    private Instant lastModifiedDate;

    @OneToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_level_id", referencedColumnName = "id")
    private UmsMemberLevel umsMemberLevel;

    @OneToMany(mappedBy = "umsMember")
    private List<UmsMemberRecipientAddress> umsMemberRecipientAddress;

    @PrePersist
    private void prePersist() {
        this.username = Hashing.sha256()
                .hashString(email, StandardCharsets.UTF_8)
                .toString();
        this.nickname = this.username;
        this.status = 1;
    }

    @PreUpdate
    private void preUpdate() {
    }
}
