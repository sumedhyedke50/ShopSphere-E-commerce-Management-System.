package com.ShopSphere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShopSphere.repository.ProductImageRepository;

@Service
public class ProductImageService {

	@Autowired
	private ProductImageRepository productImageRepository;
}
