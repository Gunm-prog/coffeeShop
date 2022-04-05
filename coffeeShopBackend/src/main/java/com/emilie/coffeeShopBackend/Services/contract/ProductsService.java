package com.emilie.coffeeShopBackend.Services.contract;


import com.emilie.coffeeShopBackend.Exceptions.CategoryNotFoundException;
import com.emilie.coffeeShopBackend.Exceptions.ProductsAlreadyExistsException;
import com.emilie.coffeeShopBackend.Exceptions.ProductsNotFoundException;
import com.emilie.coffeeShopBackend.Models.Dtos.ProductsDto;
import com.emilie.coffeeShopBackend.Models.Entities.Products;

import java.util.List;

public interface ProductsService {

    ProductsDto findProductsById (Long id) throws ProductsNotFoundException;

    ProductsDto save (ProductsDto productsDto) throws ProductsAlreadyExistsException;

    ProductsDto update (ProductsDto productsDto);

    boolean deleteById (Long id) throws ProductsNotFoundException;

    ProductsDto findByCategory (Long id) throws CategoryNotFoundException, ProductsNotFoundException;

    List<ProductsDto> findAllProducts();

    List<Products> searchProducts (Long id, String itemName, String itemPrice, String itemCategory);

    boolean IsAvailable (Products products);


}
