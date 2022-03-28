package com.emilie.coffeeShop.Models.Dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ShoppingCartDto implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;
    private UserDto userDto;
    private ProductsDto productsDto;
    private LocalDateTime creationDate;
}
