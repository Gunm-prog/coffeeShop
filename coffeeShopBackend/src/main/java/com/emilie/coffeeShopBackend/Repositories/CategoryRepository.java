package com.emilie.coffeeShopBackend.Repositories;

import com.emilie.coffeeShopBackend.util.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEnum, Long> {


    Optional<CategoryEnum> findById (Long id);
}

