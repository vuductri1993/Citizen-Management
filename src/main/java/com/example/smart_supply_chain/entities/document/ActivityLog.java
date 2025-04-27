package com.example.smart_supply_chain.entities.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "activity_log")
public class ActivityLog {
    @Id
    private String id;

    private Long managerId;
    private ActivityType activityType;
    private String activityDescription;
    private String relatedEntityType;
    private Long relatedEntityId;
    private Object oldValue;
    private Object newValue;
    private String ipAddress;
    private DeviceInfo deviceInfo;
    private LocalDateTime createdAt;

    @Data
    public static class DeviceInfo {
        private String browser;
        private String os;
        private String deviceType;
    }

    public enum ActivityType {
        LOGIN, LOGOUT,
        INVENTORY_CHECK, INVENTORY_UPDATE,
        PRODUCT_ADD, PRODUCT_UPDATE, PRODUCT_DELETE,
        WAREHOUSE_MANAGE,
        ORDER_PROCESS,
        SHIPMENT_TRACK,
        RETURN_PROCESS,
        SYSTEM_SETTING
    }
}