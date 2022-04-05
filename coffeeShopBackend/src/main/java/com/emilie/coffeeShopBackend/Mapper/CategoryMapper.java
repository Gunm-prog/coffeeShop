package com.emilie.coffeeShopBackend.Mapper;

import com.emilie.coffeeShopBackend.Models.Dtos.CategoryDto;
import com.emilie.coffeeShopBackend.Models.Entities.Category;
import com.emilie.coffeeShopBackend.util.CategoryEnum;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel= "spring", uses = {ProductsMapper.class})
public interface CategoryMapper {

    CategoryMapper categoryDtoToCategory (CategoryDto categoryDto);

    @InheritInverseConfiguration
    CategoryDto categoryToCategoryDto (Category category);

    CategoryDto categoryToCategoryDto (Optional<CategoryEnum> findById);
}
