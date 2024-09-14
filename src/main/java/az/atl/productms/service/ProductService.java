package az.atl.productms.service;

import az.atl.productms.model.request.SaveProductDto;
import az.atl.productms.model.response.ProductResponseDto;

public interface ProductService {
    void saveProduct(SaveProductDto dto);

    ProductResponseDto getResponseById(Long id);

    void reduceProductCount(Long id, Integer count);
}
