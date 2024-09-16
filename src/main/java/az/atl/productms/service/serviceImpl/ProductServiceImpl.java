package az.atl.productms.service.serviceImpl;

import az.atl.productms.dao.entity.ProductEntity;
import az.atl.productms.dao.repository.ProductRepository;
import az.atl.productms.exception.NotFoundException;
import az.atl.productms.model.request.SaveProductDto;
import az.atl.productms.model.response.ProductResponseDto;
import az.atl.productms.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static az.atl.productms.mapper.ProductMapper.PRODUCT_MAPPER;
import static az.atl.productms.model.enums.ErrorMessage.PRODUCT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void saveProduct(SaveProductDto dto) {
        var entity = PRODUCT_MAPPER.buildProductEntity(dto);
        productRepository.save(entity);
    }

    @Override
    public ProductResponseDto getResponseById(Long id) {
        var entity = fetchProductIfExist(id);
        return PRODUCT_MAPPER.buildProductResponseDto(entity);
    }

    @Override
    public void reduceProductCount(Long id, Integer count) {
        var entity = fetchProductIfExist(id);
        var updatedCount = entity.getCount() - count;
        entity.setCount(updatedCount);
        productRepository.save(entity);
    }

    private ProductEntity fetchProductIfExist(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new NotFoundException(PRODUCT_NOT_FOUND.format(id))
        );
    }
}
