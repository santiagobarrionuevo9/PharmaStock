package org.example.pharmastockback.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pharmastockback.Entities.Enums.AlertSeverity;
import org.example.pharmastockback.Entities.Enums.AlertStatus;

import java.time.OffsetDateTime;

@Entity
@Table(name = "alert_events")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rule_id", nullable = false)
    private AlertRule rule;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batch_id")
    private Batch batch;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "alert_severity")
    private AlertSeverity severity = AlertSeverity.WARN;

    @Column(nullable = false)
    private String message;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "alert_status")
    private AlertStatus status = AlertStatus.OPEN;

    @Column(name = "generated_at", nullable = false)
    private OffsetDateTime generatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ack_by_user_id")
    private User ackBy;

    @Column(name = "ack_at")
    private OffsetDateTime ackAt;

    @PrePersist
    void onCreate() {
        generatedAt = OffsetDateTime.now();
    }
}