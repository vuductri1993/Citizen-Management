package com.example.smart_supply_chain.entities.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "data_change_log")
public class DataChangeLog {
    @Id
    private String id;

    private Long managerId;
    private String tableName;
    private Long recordId;
    private ChangeType changeType;
    private String fieldName;
    private Object oldValue;
    private Object newValue;
    private LocalDateTime changeTime;
    private String ipAddress;
    private DeviceInfo deviceInfo;
    private LocalDateTime createdAt;

    @Data
    public static class DeviceInfo {
        private String browser;
        private String os;
        private String deviceType;
    }

    public enum ChangeType {
        INSERT, UPDATE, DELETE
    }
}