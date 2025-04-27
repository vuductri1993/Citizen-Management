package com.example.smart_supply_chain.entities.entitiesDb;

import com.example.smart_supply_chain.enums.Gender;
import com.example.smart_supply_chain.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "merchant_owners")
public class MerchantOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column
    private String address;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "id_card_number", nullable = false, unique = true)
    private String idCardNumber;

    @Column(name = "id_card_issue_date")
    private LocalDate idCardIssueDate;

    @Column(name = "id_card_issue_place")
    private String idCardIssuePlace;

    @Column(name = "bank_account")
    private String bankAccount;

    @Column(name = "bank_name")
    private String bankName;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE'")
    private Status status = Status.ACTIVE;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "owner")
    private List<Merchant> merchants;

    @OneToMany(mappedBy = "user")
    private List<ReturnRequest> returnRequests;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "user")
    private List<EWallet> eWallets;

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