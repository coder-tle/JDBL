package com.digiLib.configClass;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//public class SecurityConfig {
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//		http.authorizeHttpRequests(auth->
//			auth.requestMatchers("/admin").hasRole("ADMIN")
//				.requestMatchers("/user").hasRole("USER")
//				.anyRequest().authenticated())
//		.httpBasic(Customizer.withDefaults())
//		.formLogin(AbstractHttpConfigurer::disable);
//		return http.build();
//	}
	
//	@Bean //-- inMemoryWeAreAdding the role & authentication | by default spring encodes a password by default if you don't want then do (noop)
//	public UserDeailsService users() {
//		//UserDetails admin 
//	        return new InMemoryUserDetailsManager(
//	            User.withUsername("admin")
//	                .password("{bcrypt}$2a$10$...")
//	                .roles("ADMIN")
//	                .build()
//	        );
//	 
//	}
//}
