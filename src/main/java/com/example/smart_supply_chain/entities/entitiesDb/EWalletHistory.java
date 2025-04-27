package com.example.smart_supply_chain.entities.entitiesDb;

import com.example.smart_supply_chain.enums.WalletTransactionType;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "e_wallet_history")
public class EWalletHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "e_wallet_id", nullable = false)
    private EWallet eWallet;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private WalletTransactionType type;

    @Column(name = "description")
    private String description;

    @Column(name = "balance_before", nullable = false)
    private Double balanceBefore;

    @Column(name = "balance_after", nullable = false)
    private Double balanceAfter;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}