package com.emilie.coffeeShopBackend.Services.impl;

import com.emilie.coffeeShopBackend.Exceptions.*;
import com.emilie.coffeeShopBackend.Mapper.CategoryMapper;
import com.emilie.coffeeShopBackend.Mapper.ProductsMapper;
import com.emilie.coffeeShopBackend.Mapper.ShoppingCartMapper;
import com.emilie.coffeeShopBackend.Models.Dtos.ProductsDto;
import com.emilie.coffeeShopBackend.Models.Entities.Products;
import com.emilie.coffeeShopBackend.Repositories.CategoryRepository;
import com.emilie.coffeeShopBackend.Repositories.ProductsRepository;
import com.emilie.coffeeShopBackend.Repositories.ShoppingCartRepository;
import com.emilie.coffeeShopBackend.Services.contract.ProductsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductsServiceImpl implements ProductsService {

    private Logger logger = LoggerFactory.getLogger(ProductsServiceImpl.class);

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
        Optional<Products> optionalProducts = productsRepository.findProductsById( id );
        if (!optionalProducts.isPresent()){
            throw new ProductsNotFoundException( "Products not found" );
        }
        Products products = optionalProducts.get();
        return productsMapper.productsToProductsDto( productsRepository.findProductsById( id ) );
    }

    //TODO See how to manage Category and CategoryEnum
    @Override
    public ProductsDto findByCategory(Long id) throws CategoryNotFoundException, ProductsNotFoundException {
        return null;
    }

    @Override
    public ProductsDto save(ProductsDto productsDto) throws ProductsAlreadyExistsException {

        Optional<Products> optionalProducts = productsRepository.findProductsById( productsDto.getId() );

        if (optionalProducts.isPresent()){
            throw new ProductsAlreadyExistsException( "product" + productsRepository.findByItemName( productsDto.getItemName() ) + "already exists");
        }
        Products products =(Products) productsMapper.productsDtoToProducts( productsDto );
        products.setItemName( optionalProducts.get().getItemName() );
        products = productsRepository.save( products );
        return productsMapper.productsToProductsDto( products );
    }

    /*    Optional<Products> optionalProducts = productsMapper.productsDtoToProducts( productsDto );

        if (optionalProducts.isPresent()){
            throw new ProductsAlreadyExistsException( "product" + productsMapper.getItemName() + "already exists" );
        }
        Products products = productsMapper.productsDtoToProducts( productsDto );
        products.setItemName( optionalProducts.get() );
        products = productsRepository.save( products );
        return productsMapper.productsToProductsDto( products );
    }*/



    @Override
    public ProductsDto update(ProductsDto productsDto) throws ProductsNotFoundException {

        Optional<Products> optionalProducts = productsRepository.findProductsById( productsDto.getId() );
        if (!optionalProducts.isPresent()){
            throw new ProductsNotFoundException( "product" + productsDto.getId() + "not found" );
        }

        Products products = optionalProducts.get();
        products.setItemPrice( productsDto.getItemPrice() );
        products.setCategoryEnum( productsDto.getCategoryEnum() );
        /*products.setCategory( productsDto.getCategoryDto() );*/
        products.setItemName( productsDto.getItemName() );
        products = productsRepository.save( products );
        return productsMapper.productsToProductsDto( products );

    }

    @Override
    public boolean deleteById(Long id) throws ProductsNotFoundException, ImpossibleDeleteProductsException {
        Optional<Products> optionalProducts = productsRepository.findProductsById( id );
        if (!optionalProducts.isPresent()){
            throw new ProductsNotFoundException( "product" + id + "not found" );
        }else {
            Products products = optionalProducts.get();
        }
        try{
            productsRepository.deleteById( id );
        }catch (Exception e ){
            return false;
        }
        return true;

    }




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



    @Override
    public List<Products> searchProducts (Long id, String itemName, String itemPrice, String itemCategory){
        List<Products> products;
        products = productsRepository.searchProducts (id, itemName, itemPrice, itemCategory);

        List<Products> productsDtos = new ArrayList<>();
        for (Products products1 : products) {
            ProductsDto productsDto = productsMapper.productsToProductsDto( products1 );

        }
        return productsDtos;
    }

    //TODO See if necessary and if so, implement it
    @Override
    public boolean IsAvailable(Products products) {
        return false;
    }

}
