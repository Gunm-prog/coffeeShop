package com.emilie.coffeeShop.Services.contract;

import com.emilie.coffeeShop.Exceptions.CategoryNotFoundException;
import com.emilie.coffeeShop.Exceptions.ProductsAlreadyExistsException;
import com.emilie.coffeeShop.Exceptions.ProductsNotFoundException;
import com.emilie.coffeeShop.Models.Dtos.ProductsDto;
import com.emilie.coffeeShop.Models.Entities.Products;

import java.util.List;

public interface ProductsService {

    ProductsDto findProductsById (Long id) throws ProductsNotFoundException;

    ProductsDto save (ProductsDto productsDto) throws ProductsAlreadyExistsException;

    ProductsDto update (ProductsDto productsDto);

    boolean deleteById (Long id) throws ProductsNotFoundException;

    ProductsDto findByCategory (Long id) throws CategoryNotFoundException, ProductsNotFoundException;

    List<ProductsDto> findAllProducts();

    List<Products> searchProducts (Long id, String itemName, String itemPrice, String itemCategory);

    boolean productsIsAvailable (Products products);


}
