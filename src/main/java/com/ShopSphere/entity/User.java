package com.ShopSphere.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long userId;

	    private String firstName;
	    
	    private String lastName;

	    @Column(nullable = false, unique = true)
	    private String email;

	    @Column(nullable = false)
	    private String password;

	    @ManyToMany
	    @JoinTable(
	        name = "user_roles",
	        joinColumns = @JoinColumn(name = "userId"),
	        inverseJoinColumns = @JoinColumn(name = "roleId")
	    )
	    private Set<Role> roles = new HashSet<>();

	    @OneToMany(mappedBy = "user",
	               cascade = CascadeType.ALL,
	               orphanRemoval = true)
	    private List<Address> addresses = new ArrayList<>();
	}