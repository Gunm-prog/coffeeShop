package com.emilie.coffeeShopBackend.Repositories;

import com.emilie.coffeeShopBackend.Models.Entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

/*List<Products> findProductsById (Long id);*/


List<Products> findAllProducts();

Optional<Products> findProductsById (Long id);

Optional<Products> findByItemName (String itemName);


List<Products> searchProducts(@Param("id") Long id,
                              @Param( "itemName" ) String itemName,
                              @Param( "itemPrice" ) String itemPrice,
                              @Param( "itemCategory" ) String itemCategory);
}
