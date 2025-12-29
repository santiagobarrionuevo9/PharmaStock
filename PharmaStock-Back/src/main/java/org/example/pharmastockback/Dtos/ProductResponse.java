package org.example.pharmastockback.Dtos;

import lombok.Data;

import java.time.OffsetDateTime;
@Data
public class ProductResponse {
    private Long id;
    private String sku;
    private String barcode;
    private String name;
    private String genericName;
    private String form;
    private String strength;
    private String presentation;
    private String laboratory;
    private Boolean isActive;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
