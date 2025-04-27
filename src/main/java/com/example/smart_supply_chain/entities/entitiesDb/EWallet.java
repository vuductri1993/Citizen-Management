package com.example.smart_supply_chain.entities.entitiesDb;

import com.example.smart_supply_chain.enums.WalletStatus;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "e_wallets")
public class EWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private MerchantOwner user;

    @Column(name = "balance", nullable = false)
    private Double balance = 0.0;

    @Column(name = "currency", length = 3)
    private String currency = "VND";

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('ACTIVE', 'INACTIVE', 'FROZEN') DEFAULT 'ACTIVE'")
    private WalletStatus status = WalletStatus.ACTIVE;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "eWallet")
    private List<EWalletHistory> walletHistory;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}