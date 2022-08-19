package net.javaguides.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import net.javaguides.springboot.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// Trang chỉ dành cho ADMIN
		http.authorizeRequests().antMatchers("/users-tables","/edit-user-table/*","/saveUser","/saveUserTable","/deleteUser/*"
				,"/booking-tables","/edit/*","/delete/*"
				,"/booking-home-table","/editBookingHome/*","/deleteBookingHome/*"
				,"/contact-table","/saveContact","/editContact/*","/deleteContact/*"
				,"/product-tables","/new-products","/saveProduct","/editProduct/*","/deleteProduct/*"
				,"/role-tables","/role-new","/saveRole","/editRole/*","/deleteRole/*"
				,"/sample-hair-top-view","/sample-hair-table","/sample-hair-news","/saveSampleHair","/editSampleHair/*","/deleteSampleHair/"
				,"/service-hair-tables","/service-hair-top-view","/service-hair-new","/saveServiceHair","/editServiceHair/*","/deleteServiceHair/*"
				,"/booking-service-hair/*","/admin-table"
				).access("hasRole('ROLE_ADMIN')");
		
		// Trang chỉ dành cho ADMIN,và User
		http.authorizeRequests().antMatchers("/").access("hasAnyRole('ROLE_ADMIN','ROLE_USER')"); 

		
		// Các trang không yêu cầu login
		http.authorizeRequests().antMatchers("/home", "/login", "/logout","/registration","/booking-new/").permitAll();
		
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/404");
		
		
		http.authorizeRequests().antMatchers(
				 "/registration**",
	                "/js/**",
	                "/css/**",
	                "/img/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true) 
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/home")
		.permitAll();
	}

}
