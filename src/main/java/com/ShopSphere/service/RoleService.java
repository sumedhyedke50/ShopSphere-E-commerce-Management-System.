package com.ShopSphere.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShopSphere.repository.RoleRepository;
@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

}
