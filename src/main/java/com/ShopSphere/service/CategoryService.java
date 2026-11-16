package com.ShopSphere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShopSphere.entity.Category;
import com.ShopSphere.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	private Category saveCategory(Category category)
	{
		return  categoryRepository.save(category);
	}
}
