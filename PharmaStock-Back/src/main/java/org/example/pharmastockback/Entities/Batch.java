package org.example.pharmastockback.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.pharmastockback.Entities.Enums.BatchStatus;

@Entity
@Table(name = "batches",
        uniqueConstraints = @UniqueConstraint(name="uq_batches_product_code_exp", columnNames={"product_id","batch_code","expires_at"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="product_id", nullable = false)
    private Product product;

    @Column(name="batch_code", nullable = false)
    private String batchCode;

    @Column(name="expires_at", nullable = false)
    private java.time.LocalDate expiresAt;

    @Column(name="manufacturer_ref")
    private String manufacturerRef;

    // Si mantenés Postgres ENUM: @Enumerated(EnumType.STRING) + custom type o cambiar DB a TEXT
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BatchStatus status;

    private String notes;
}
