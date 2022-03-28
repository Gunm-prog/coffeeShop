package com.emilie.coffeeShop.Services.impl;

import com.emilie.coffeeShop.Exceptions.CategoryNotFoundException;
import com.emilie.coffeeShop.Exceptions.ProductsAlreadyExistsException;
import com.emilie.coffeeShop.Exceptions.ProductsNotFoundException;
import com.emilie.coffeeShop.Mapper.CategoryMapper;
import com.emilie.coffeeShop.Mapper.ProductsMapper;
import com.emilie.coffeeShop.Mapper.ShoppingCartMapper;
import com.emilie.coffeeShop.Models.Dtos.ProductsDto;
import com.emilie.coffeeShop.Models.Entities.Products;
import com.emilie.coffeeShop.Repositories.CategoryRepository;
import com.emilie.coffeeShop.Repositories.ProductsRepository;
import com.emilie.coffeeShop.Repositories.ShoppingCartRepository;
import com.emilie.coffeeShop.Services.contract.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;
    private final CategoryRepository categoryRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductsMapper productsMapper;
    private final CategoryMapper categoryMapper;
    private final ShoppingCartMapper shoppingCartMapper;


    @Autowired
    public ProductsServiceImpl(ProductsRepository productsRepository,
                               CategoryRepository categoryRepository,
                               ShoppingCartRepository shoppingCartRepository,
                               ProductsMapper productsMapper,
                               CategoryMapper categoryMapper,
                               ShoppingCartMapper shoppingCartMapper){
        this.productsRepository = productsRepository;
        this.categoryRepository = categoryRepository;
        this.shoppingCartRepository = shoppingCartRepository;
        this.productsMapper = productsMapper;
        this.categoryMapper = categoryMapper;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @Override
    public ProductsDto findProductsById(Long id) throws ProductsNotFoundException {
        return null;
    }

    @Override
    public ProductsDto save(ProductsDto productsDto) throws ProductsAlreadyExistsException {
        return null;
    }

    @Override
    public ProductsDto update(ProductsDto productsDto) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) throws ProductsNotFoundException {
        return false;
    }

    @Override
    public ProductsDto findByCategory(Long id) throws CategoryNotFoundException, ProductsNotFoundException {
        return null;
    }

  /*  @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = userMapper.userToUserDto(user);
            userDto.setPassword("");
            userDtos.add(userDto);
        }
        return userDtos;
    }*/

    @Override
    public List<ProductsDto> findAllProducts(){
        List<Products> products = productsRepository.findAllProducts();
        List<ProductsDto> productsDtos = new ArrayList<>();
        for (Products products1 : products){
            ProductsDto productsDto = productsMapper.productsToProductsDto(products1);
            productsDto.setId(productsDto.getId());
        }
        return productsDtos;
    }

   /* @Override
    public List<ProductsDto> findAllProducts() {
        List<Products> products = productsRepository.findAllProducts();
        List<ProductsDto> productsDtos = new ArrayList<>();
        for (Products products1 : products){
            ProductsDto productsDto = productsToProductsDto (products1);
        }

        return ;
    }*/

    @Override
    public List<Products> searchProducts (Long id, String itemName, String itemPrice, String itemCategory){

        return null;
    }

    @Override
    public boolean productsIsAvailable(Products products) {
        return false;
    }

}
