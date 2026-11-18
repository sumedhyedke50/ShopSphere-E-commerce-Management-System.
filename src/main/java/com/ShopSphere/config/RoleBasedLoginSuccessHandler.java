package com.ShopSphere.config;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RoleBasedLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		
		   boolean isAdmin = authentication.getAuthorities()
	                .stream()
	                .anyMatch(authority ->
	                    authority.getAuthority().equals("ROLE_ADMIN"));

	        if (isAdmin) {
	            response.sendRedirect("/admin/dashboard");
	        } else {
	            response.sendRedirect("/customer/dashboard");
	        }
	    }
	

}
