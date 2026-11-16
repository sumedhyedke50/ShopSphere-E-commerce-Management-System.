package com.ShopSphere.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ShopSphere.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	Category findByCategoryName(String categoryName);

    boolean existsByCategoryName(String categoryName);

	Category save(Category category);
}
