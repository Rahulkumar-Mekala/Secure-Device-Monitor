package com.example.secure_device_monitor.Service;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	   private final JwtService jwtService;
	   
    public JwtAuthenticationFilter(JwtService jwtService) {
		this.jwtService = jwtService;
	}

	@Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null ||
                !authHeader.startsWith("Bearer ")) {

            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);
        if (!jwtService.validateToken(token)) {

            response.setStatus(
                    HttpServletResponse.SC_UNAUTHORIZED
            );
            
            response.setContentType("application/json");

            response.getWriter().write(
                    "{\"message\":\"Invalid or expired token\"}"
            );

            return;
        }


        System.out.println("JWT received: " + token);



        filterChain.doFilter(request, response);
    }
    
}
