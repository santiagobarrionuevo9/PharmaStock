package org.example.pharmastockback.Services.Impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.pharmastockback.Dtos.ProductCreateRequest;
import org.example.pharmastockback.Dtos.ProductResponse;
import org.example.pharmastockback.Dtos.ProductUpdateRequest;
import org.example.pharmastockback.Entities.Product;
import org.example.pharmastockback.Repositories.ProductRepository;
import org.example.pharmastockback.Services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    @Transactional
    public List<ProductResponse> list() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional
    public ProductResponse get(Long id) {
        return toResponse(repo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Producto no encontrado: id=" + id)
        ));
    }

    @Transactional
    public ProductResponse create(ProductCreateRequest req) {
        var sku = normalize(req.getSku());
        var barcode = normalize(req.getBarcode());

        if (sku != null && repo.existsBySku(sku)) {
            throw new IllegalArgumentException("SKU ya existe: " + sku);
        }
        if (barcode != null && repo.existsByBarcode(barcode)) {
            throw new IllegalArgumentException("Barcode ya existe: " + barcode);
        }

        Product p = Product.builder()
                .sku(sku)
                .barcode(barcode)
                .name(req.getName().trim())
                .genericName(normalize(req.getGenericName()))
                .form(normalize(req.getForm()))
                .strength(normalize(req.getStrength()))
                .presentation(normalize(req.getPresentation()))
                .laboratory(normalize(req.getLaboratory()))
                .isActive(req.getIsActive() != null ? req.getIsActive() : true)
                .build();

        return toResponse(repo.save(p));
    }

    @Transactional
    public ProductResponse update(Long id, ProductUpdateRequest req) {
        Product p = repo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Producto no encontrado: id=" + id)
        );

        var sku = normalize(req.getSku());
        var barcode = normalize(req.getBarcode());

        if (sku != null && !sku.equals(p.getSku()) && repo.existsBySku(sku)) {
            throw new IllegalArgumentException("SKU ya existe: " + sku);
        }
        if (barcode != null && !barcode.equals(p.getBarcode()) && repo.existsByBarcode(barcode)) {
            throw new IllegalArgumentException("Barcode ya existe: " + barcode);
        }

        p.setSku(sku);
        p.setBarcode(barcode);
        p.setName(req.getName().trim());
        p.setGenericName(normalize(req.getGenericName()));
        p.setForm(normalize(req.getForm()));
        p.setStrength(normalize(req.getStrength()));
        p.setPresentation(normalize(req.getPresentation()));
        p.setLaboratory(normalize(req.getLaboratory()));
        p.setIsActive(req.getIsActive() != null ? req.getIsActive() : p.getIsActive());

        return toResponse(repo.save(p));
    }

    @Transactional
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Producto no encontrado: id=" + id);
        }
        repo.deleteById(id);
    }

    private ProductResponse toResponse(Product p) {
        ProductResponse res = new ProductResponse();
        res.setId(p.getId());
        res.setSku(p.getSku());
        res.setBarcode(p.getBarcode());
        res.setName(p.getName());
        res.setGenericName(p.getGenericName());
        res.setForm(p.getForm());
        res.setStrength(p.getStrength());
        res.setPresentation(p.getPresentation());
        res.setLaboratory(p.getLaboratory());
        res.setIsActive(p.getIsActive());
        res.setCreatedAt(p.getCreatedAt());
        res.setUpdatedAt(p.getUpdatedAt());
        return  res;
    }

    private String normalize(String s) {
        if (s == null) return null;
        var t = s.trim();
        return t.isEmpty() ? null : t;
    }
}
