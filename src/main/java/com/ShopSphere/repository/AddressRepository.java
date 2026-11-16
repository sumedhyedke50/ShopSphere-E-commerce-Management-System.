package com.ShopSphere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ShopSphere.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	List<Address> findByUserUserId(Long userId);

	List<Address> findByCity(String city);
}
