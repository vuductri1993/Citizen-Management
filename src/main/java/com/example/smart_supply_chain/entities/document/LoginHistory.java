package com.example.smart_supply_chain.entities.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "login_history")
public class LoginHistory {
    @Id
    private String id;

    private Long managerId;
    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;
    private String ipAddress;
    private DeviceInfo deviceInfo;
    private String sessionId;
    private Status status;
    private String failureReason;
    private LocalDateTime createdAt;

    @Data
    public static class DeviceInfo {
        private String browser;
        private String os;
        private String deviceType;
    }

    public enum Status {
        SUCCESS, FAILED
    }
}