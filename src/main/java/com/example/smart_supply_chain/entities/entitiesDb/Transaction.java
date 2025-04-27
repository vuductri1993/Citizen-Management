package com.example.smart_supply_chain.entities.entitiesDb;

import com.example.smart_supply_chain.enums.TransactionStatus;
import com.example.smart_supply_chain.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_code", nullable = false, unique = true)
    private String transactionCode;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private MerchantOwner user;

    @ManyToOne
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethod paymentMethod;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "currency", length = 3)
    private String currency = "VND";

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('PENDING', 'PROCESSING', 'COMPLETED', 'FAILED', 'REFUNDED') DEFAULT 'PENDING'")
    private TransactionStatus status = TransactionStatus.PENDING;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @Column(name = "bank_transaction_id")
    private String bankTransactionId;

    @Column(name = "payment_gateway_response")
    private String paymentGatewayResponse;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "transaction")
    private List<TransactionDetail> transactionDetails;

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