package com.example.smart_supply_chain.entities.entitiesDb;

import com.example.smart_supply_chain.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "merchants")
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private MerchantOwner owner;

    @Column(name = "business_name", nullable = false)
    private String businessName;

    @Column(name = "business_registration", unique = true)
    private String businessRegistration;

    @Column(name = "tax_code", unique = true)
    private String taxCode;

    @Column(name = "business_address")
    private String businessAddress;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "bank_account")
    private String bankAccount;

    @Column(name = "bank_name")
    private String bankName;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('ACTIVE', 'INACTIVE', 'SUSPENDED') DEFAULT 'ACTIVE'")
    private Status status = Status.ACTIVE;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "merchant")
    private List<MerchantWarehouse> warehouses;

    @OneToMany(mappedBy = "merchant")
    private List<MerchantInventory> inventories;

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