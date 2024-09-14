package az.atl.productms.mapper;

import az.atl.productms.dao.entity.ProductEntity;
import az.atl.productms.model.request.SaveProductDto;
import az.atl.productms.model.response.ProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductEntity buildProductEntity(SaveProductDto dto);

    ProductResponseDto buildProductResponseDto(ProductEntity entity);
}
