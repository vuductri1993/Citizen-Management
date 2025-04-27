package com.example.smart_supply_chain.entities.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "feature_access")
public class FeatureAccess {
    @Id
    private String id;

    private Long managerId;
    private String featureName;
    private LocalDateTime accessTime;
    private AccessType accessType;
    private AccessResult accessResult;
    private String failureReason;
    private String ipAddress;
    private DeviceInfo deviceInfo;
    private LocalDateTime createdAt;

    @Data
    public static class DeviceInfo {
        private String browser;
        private String os;
        private String deviceType;
    }

    public enum AccessType {
        VIEW, CREATE, UPDATE, DELETE
    }

    public enum AccessResult {
        SUCCESS, FAILED
    }
}