package com.emilie.coffeeShop.Mapper;

import com.emilie.coffeeShop.Models.Dtos.CategoryDto;
import com.emilie.coffeeShop.Models.Entities.Category;
import com.emilie.coffeeShop.util.CategoryEnum;
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
