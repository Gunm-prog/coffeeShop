package com.emilie.coffeeShopBackend.Models.Dtos;

import com.emilie.coffeeShopBackend.util.CategoryEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CategoryDto implements Serializable {

    private static final long serialVersionUID=1L;

    private Long id;
    private String categoryName;
    private CategoryEnum categoryEnum;
}
