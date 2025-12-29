package org.example.pharmastockback.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="warehouse_id", nullable = false)
    private Warehouse warehouse;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="batch_id", nullable = false)
    private Batch batch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="location_id") // nullable permitido
    private Location location;

    @Column(name="qty_on_hand", nullable = false, precision = 18, scale = 3)
    private java.math.BigDecimal qtyOnHand;

    @Column(name="qty_reserved", nullable = false, precision = 18, scale = 3)
    private java.math.BigDecimal qtyReserved;

    @Column(name="min_qty", precision = 18, scale = 3)
    private java.math.BigDecimal minQty;
}

