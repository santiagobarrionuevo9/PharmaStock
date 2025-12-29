package org.example.pharmastockback.Services;

import org.example.pharmastockback.Dtos.ProductCreateRequest;
import org.example.pharmastockback.Dtos.ProductResponse;
import org.example.pharmastockback.Dtos.ProductUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<ProductResponse> list();

    ProductResponse get(Long id);

    ProductResponse create(ProductCreateRequest req);

    ProductResponse update(Long id, ProductUpdateRequest req);

    void delete(Long id);
}
