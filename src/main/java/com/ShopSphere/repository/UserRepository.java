package com.ShopSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShopSphere.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	boolean existsByEmail(String email);
}
