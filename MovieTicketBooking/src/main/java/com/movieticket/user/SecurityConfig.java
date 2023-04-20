package com.movieticket.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
		List <UserDetails> users=new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder()
				.username("pratiksha")
				.password("pass")
				.roles("USER")
				.build());
		
		users.add(User.withDefaultPasswordEncoder()
				.username("jack")
				.password("pass")
				.roles("USER")
				.build());
		

		return new InMemoryUserDetailsManager(users);
	}

	
	
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	          .authorizeRequests()
	          .antMatchers("/movies/**").authenticated()
	          .and()
	          .httpBasic();
	    }
	


}
