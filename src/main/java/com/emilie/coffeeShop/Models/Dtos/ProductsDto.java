package com.emilie.coffeeShop.Models.Dtos;

import com.emilie.coffeeShop.util.CategoryEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProductsDto implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;
    private String itemName;
    private double itemPrice;
    private int itemQuantity;
    private CategoryDto categoryDto;
    private CategoryEnum categoryEnum;
    private ShoppingCartDto shoppingCartDto;
    private boolean isAvailable;
}
