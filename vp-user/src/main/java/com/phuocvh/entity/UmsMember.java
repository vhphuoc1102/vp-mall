package com.phuocvh.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Builder
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ums_member")
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
    @NotBlank
    private String phone;
    @ColumnDefault("1")
    private Integer status;
    private String icon;
    @NotBlank
    private String gender;
    @NotBlank
    private String birthday;
    @CreationTimestamp
    private Instant createdTime;
    @UpdateTimestamp
    private Instant updatedTime;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_level_id", referencedColumnName = "id")
    private UmsMemberLevel umsMemberLevel;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_receive_address_id", referencedColumnName = "id")
    private UmsMemberRecipientAddress umsMemberRecipientAddress;

    @PrePersist
    public void prePersist() {
        if (this.nickname.isBlank())
            this.nickname = "@" + this.username;
        else
            this.nickname = "@" + this.nickname;
    }
}
