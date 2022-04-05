package com.emilie.coffeeShopBackend.Services.contract;

import com.emilie.coffeeShopBackend.Exceptions.ProductsNotFoundException;
import com.emilie.coffeeShopBackend.Exceptions.ShoppingCartNotFoundException;
import com.emilie.coffeeShopBackend.Exceptions.UnauthorizedException;
import com.emilie.coffeeShopBackend.Exceptions.UserNotFoundException;
import com.emilie.coffeeShopBackend.Models.Dtos.ProductsDto;
import com.emilie.coffeeShopBackend.Models.Dtos.ShoppingCartDto;
import com.emilie.coffeeShopBackend.Models.Dtos.UserDto;
import feign.FeignException;

import java.util.List;

public interface ShoppingCartService {

    ShoppingCartDto findById (Long id) throws ShoppingCartNotFoundException;

    /**
     * @return ShoppingCartDto
     * @throws UserNotFoundException, ProductsNotFoundException,
      UnauthorizedException
     */
    ShoppingCartDto create (ShoppingCartDto shoppingCartDto, UserDto userDto, ProductsDto productsDto) throws UserNotFoundException, ProductsNotFoundException, UnauthorizedException;

    List<ShoppingCartDto> findAll();
    List<ShoppingCartDto> findShoppingCartByUserId(Long id);
    List<ShoppingCartDto> getShoppingCartByProductsId (Long id);

    void deleteById (Long id) throws ShoppingCartNotFoundException;

    void haveAccess(UserDto loggedUser, ShoppingCartDto shoppingCartDto) throws UnauthorizedException;
    void isValid(ShoppingCartDto shoppingCartDto) throws UserNotFoundException, ProductsNotFoundException;

}
