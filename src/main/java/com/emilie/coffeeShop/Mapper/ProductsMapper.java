package com.emilie.coffeeShop.Mapper;

import com.emilie.coffeeShop.Models.Dtos.ProductsDto;
import com.emilie.coffeeShop.Models.Entities.Products;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, ShoppingCartMapper.class})
public interface ProductsMapper {

    ProductsMapper productsDtoToProducts (ProductsDto productsDto);

    @InheritInverseConfiguration
    ProductsDto productsToProductsDto (Products products);

    ProductsDto productsToProductsDto (Optional<Products> findByProductId);


}
