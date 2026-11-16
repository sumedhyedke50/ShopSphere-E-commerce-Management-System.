package com.ShopSphere.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ShopSphere.dto.RegistrationDto;
import com.ShopSphere.entity.Role;
import com.ShopSphere.entity.User;
import com.ShopSphere.repository.RoleRepository;
import com.ShopSphere.repository.UserRepository;

@Service
public class RegistrationService {

	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private final RoleRepository roleRepository;
	@Autowired
	private final PasswordEncoder passwordEncoder;

	public RegistrationService(UserRepository userRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {

		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}
	

	public User registerUser(RegistrationDto dto) {

		if (checkEmailExists(dto.getEmail())) {
			throw new IllegalArgumentException("Email already exists!");
		}

		if (!dto.getPassword().equals(dto.getConfirmPassword())) {
			throw new IllegalArgumentException("Passwords do not match!");
		}

		User user = new User();

		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setEmail(dto.getEmail());

		user.setPassword(encodePassword(dto.getPassword()));

		Set<Role> roles = new HashSet<>();
		roles.add(assignDefaultRole());

		user.setRoles(roles);

		return userRepository.save(user);
	}

	public boolean checkEmailExists(String email) {

		return userRepository.existsByEmail(email);
	}

	public String encodePassword(String password) {

		return passwordEncoder.encode(password);
	}

	public Role assignDefaultRole() {

		return roleRepository.findByRoleName("CUSTOMER")
				.orElseThrow(() -> new IllegalStateException("CUSTOMER role not found!"));
	}
}
