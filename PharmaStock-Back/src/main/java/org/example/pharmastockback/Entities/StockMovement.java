package org.example.pharmastockback.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pharmastockback.Entities.Enums.MovementType;

@Entity
@Table(name="stock_movements")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="warehouse_id", nullable = false)
    private Warehouse warehouse;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="product_id", nullable = false)
    private Product product;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="batch_id", nullable = false)
    private Batch batch;

    @Enumerated(EnumType.STRING)
    @Column(name="movement_type", nullable = false)
    private MovementType movementType;

    @Column(nullable = false, precision = 18, scale = 3)
    private java.math.BigDecimal qty;

    @Column(nullable = false)
    private String reason;

    private String reference;
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="from_location_id")
    private Location fromLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="to_location_id")
    private Location toLocation;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="performed_by_user_id", nullable = false)
    private User performedBy;

    @Column(name="occurred_at", nullable = false)
    private java.time.OffsetDateTime occurredAt;
}

