package com.ShopSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShopSphere.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRoleName(String roleName);

	boolean existsByRoleName(String roleName);
}
