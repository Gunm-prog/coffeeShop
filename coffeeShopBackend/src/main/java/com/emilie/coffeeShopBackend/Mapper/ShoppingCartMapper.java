package com.emilie.coffeeShopBackend.Mapper;

import com.emilie.coffeeShopBackend.Models.Dtos.ShoppingCartDto;
import com.emilie.coffeeShopBackend.Models.Entities.ShoppingCart;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper (componentModel = "spring", uses = {UserMapper.class, ProductsMapper.class})
public interface ShoppingCartMapper {

    ShoppingCartMapper shoppingCartDtoToShoppingCart (ShoppingCartDto shoppingCartDto);

    @InheritInverseConfiguration
    ShoppingCartDto shoppingCartToShoppingCartDto (ShoppingCart shoppingCart);

    ShoppingCartDto shoppingCartToShoppingCartDto(Optional<ShoppingCart> findById);

    ShoppingCartDto shoppingCartDtoToShoppingCart(ShoppingCart savedShoppingCart);
}
