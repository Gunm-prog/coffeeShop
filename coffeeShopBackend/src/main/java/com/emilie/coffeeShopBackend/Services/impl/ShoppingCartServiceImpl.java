package com.emilie.coffeeShopBackend.Services.impl;

import com.emilie.coffeeShopBackend.Exceptions.ProductsNotFoundException;
import com.emilie.coffeeShopBackend.Exceptions.ShoppingCartNotFoundException;
import com.emilie.coffeeShopBackend.Exceptions.UnauthorizedException;
import com.emilie.coffeeShopBackend.Exceptions.UserNotFoundException;
import com.emilie.coffeeShopBackend.Mapper.ProductsMapper;
import com.emilie.coffeeShopBackend.Mapper.ShoppingCartMapper;
import com.emilie.coffeeShopBackend.Mapper.UserMapper;
import com.emilie.coffeeShopBackend.Models.Dtos.ProductsDto;
import com.emilie.coffeeShopBackend.Models.Dtos.ShoppingCartDto;
import com.emilie.coffeeShopBackend.Models.Dtos.UserDto;
import com.emilie.coffeeShopBackend.Models.Entities.ShoppingCart;
import com.emilie.coffeeShopBackend.Repositories.ProductsRepository;
import com.emilie.coffeeShopBackend.Repositories.ShoppingCartRepository;
import com.emilie.coffeeShopBackend.Repositories.UserRepository;
import com.emilie.coffeeShopBackend.Services.contract.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final ProductsRepository productsRepository;

    private final ShoppingCartMapper shoppingCartMapper;
    private final UserMapper userMapper;
    private final ProductsMapper productsMapper;

    @Autowired
    public ShoppingCartServiceImpl (ShoppingCartRepository shoppingCartRepository,
                                    UserRepository userRepository,
                                    ProductsRepository productsRepository,
                                    ShoppingCartMapper shoppingCartMapper,
                                    UserMapper userMapper,
                                    ProductsMapper productsMapper) {
        this.shoppingCartRepository= shoppingCartRepository;
        this.userRepository = userRepository;
        this.productsRepository = productsRepository;
        this.shoppingCartMapper = shoppingCartMapper;
        this.userMapper = userMapper;
        this.productsMapper = productsMapper;
    }

    @Override
    public ShoppingCartDto findById(Long id) throws ShoppingCartNotFoundException {
        return null;
    }

    @Override
    public ShoppingCartDto create(ShoppingCartDto shoppingCartDto, UserDto userDto, ProductsDto productsDto) throws UserNotFoundException, ProductsNotFoundException, UnauthorizedException {

        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.setUser( userMapper.userDtoToUser( userDto ) );
        shoppingCart.setProducts(productsMapper.productsToProductsDto( productsDto )  );
        shoppingCart.setProducts( productsMapper.productsToProductsDto( productsDto ) );
        shoppingCart.setCreationDate( LocalDateTime.now() );
        //shoppingCart.setStatus(Status.ONGOING);

        ShoppingCart savedShoppingCart = shoppingCartRepository.save( shoppingCart );

        return shoppingCartMapper.shoppingCartDtoToShoppingCart( savedShoppingCart );
    }

    @Override
    public List<ShoppingCartDto> findAll() {
        List<ShoppingCart> shoppingCarts = shoppingCartRepository.findAll();
        List<ShoppingCartDto> shoppingCartDtos = new ArrayList<>();
        for (ShoppingCart shoppingCart : shoppingCarts){
            ShoppingCartDto shoppingCartDto = shoppingCartMapper.shoppingCartToShoppingCartDto( shoppingCart );
            shoppingCartDtos.add( shoppingCartDto );
        }
        return shoppingCartDtos;
    }

    @Override
    public List<ShoppingCartDto> findShoppingCartByUserId(Long id) throws ShoppingCartNotFoundException {
        Optional<ShoppingCart> optionalShoppingCart = shoppingCartRepository.findById( id );
        if (!optionalShoppingCart.isPresent()){
            throw new ShoppingCartNotFoundException( " Shopping Cart not found " );
        }
        return null;
    }

    @Override
    public List<ShoppingCartDto> getShoppingCartByProductsId(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) throws ShoppingCartNotFoundException {

    }

    @Override
    public void haveAccess(UserDto loggedUser, ShoppingCartDto shoppingCartDto) throws UnauthorizedException {

    }

    @Override
    public void isValid(ShoppingCartDto shoppingCartDto) throws UserNotFoundException, ProductsNotFoundException {

    }
}
