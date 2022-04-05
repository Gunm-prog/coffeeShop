package com.emilie.coffeeShopBackend.Mapper;

import com.emilie.coffeeShopBackend.Models.Dtos.ProductsDto;
import com.emilie.coffeeShopBackend.Models.Entities.Products;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class,
        ShoppingCartMapper.class})
public interface ProductsMapper {

    ProductsMapper productsDtoToProducts (ProductsDto productsDto);

    @InheritInverseConfiguration
    ProductsDto productsToProductsDto (Products products);

    ProductsDto productsToProductsDto (Optional<Products> findByProductsById);


    Products productsToProductsDto(ProductsDto productsDto);
}
