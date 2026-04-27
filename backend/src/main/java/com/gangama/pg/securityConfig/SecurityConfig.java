package com.gangama.pg.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {
    
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable())
	        .cors(cors -> {})
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/customer/**").permitAll()
	            .anyRequest().permitAll()
	        );

	    return http.build();
	}
	/*
	 * @Bean public WebMvcConfigurer corsConfigurer() { return new
	 * WebMvcConfigurer() {
	 * 
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/**") .allowedOrigins("http://localhost:4300")
	 * .allowedMethods("*") .allowedHeaders("*"); } }; }
	 */
}

