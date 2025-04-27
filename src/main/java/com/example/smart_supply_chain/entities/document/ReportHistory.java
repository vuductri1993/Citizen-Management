package com.example.smart_supply_chain.entities.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@Document(collection = "report_history")
public class ReportHistory {
    @Id
    private String id;

    private Long managerId;
    private String reportType;
    private Map<String, Object> reportParameters;
    private LocalDateTime generationTime;
    private Integer downloadCount = 0;
    private String ipAddress;
    private DeviceInfo deviceInfo;
    private LocalDateTime createdAt;

    @Data
    public static class DeviceInfo {
        private String browser;
        private String os;
        private String deviceType;
    }
}