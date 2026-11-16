package com.ShopSphere.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShopSphere.entity.Role;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByRoleName(String roleName);

	@Query("SELECT r.roleId FROM Role r WHERE r.roleName = :roleName")
	boolean existsByRoleName(String roleName);
	
	
}
