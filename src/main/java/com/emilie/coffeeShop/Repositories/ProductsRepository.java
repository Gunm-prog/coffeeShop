package com.emilie.coffeeShop.Repositories;

import com.emilie.coffeeShop.Models.Entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<MenuItem, Long> {

List<Products> findProductsById (Long id);


List<Products> findAllProducts();



}
