package com.example.javastoreapi.mappers;

import com.example.javastoreapi.dtos.ProductDto;
import com.example.javastoreapi.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toDto(Product product);

    //@Mapping(target = "category", ignore = true)
//    @Mapping(target = "category.id", source = "categoryId")
    Product toEntity(ProductDto productDto);
}
