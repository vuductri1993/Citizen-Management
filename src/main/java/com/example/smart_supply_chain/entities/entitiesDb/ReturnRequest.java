package com.example.smart_supply_chain.entities.entitiesDb;

import com.example.smart_supply_chain.enums.ReturnReason;
import com.example.smart_supply_chain.enums.ReturnStatus;
import com.example.smart_supply_chain.enums.RefundMethod;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "return_requests")
public class ReturnRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private MerchantOwner user;

    @Column(name = "request_date")
    private LocalDateTime requestDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "return_reason", nullable = false)
    private ReturnReason returnReason;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('PENDING', 'APPROVED', 'REJECTED', 'PROCESSING', 'COMPLETED') DEFAULT 'PENDING'")
    private ReturnStatus status = ReturnStatus.PENDING;

    @Column(name = "refund_amount")
    private Double refundAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "refund_method")
    private RefundMethod refundMethod;

    @Column(name = "completed_date")
    private LocalDateTime completedDate;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

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