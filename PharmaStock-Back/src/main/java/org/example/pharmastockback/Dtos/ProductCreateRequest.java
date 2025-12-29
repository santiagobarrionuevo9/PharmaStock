package org.example.pharmastockback.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductCreateRequest {
    @Size(max = 50)
    private String sku;

    @Size(max = 80)
    private String barcode;

    @NotBlank
    @Size(max = 200)
    private String name;

    @Size(max = 200)
    private String genericName;

    @Size(max = 100)
    private String form;

    @Size(max = 100)
    private String strength;

    @Size(max = 120)
    private String presentation;

    @Size(max = 120)
    private String laboratory;

    private Boolean isActive;
}
