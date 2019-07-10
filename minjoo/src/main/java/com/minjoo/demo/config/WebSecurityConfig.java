package com.minjoo.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	  @Override protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests() 
		  .antMatchers("/sample/member").hasRole("MEMBER")
		  .antMatchers("/sample/admin").hasRole("ADMIN")
		  .antMatchers("/sample/all").permitAll()
	  	  .anyRequest().authenticated()
	  	  .and()
		  .formLogin()
	   		.loginPage("/customLogin")
	   		.usernameParameter("username")
	   		.passwordParameter("password")
	   	//	.loginProcessingUrl("/loginProcess")
	   	//	.defaultSuccessUrl("/loginSuccess")  	
	        .permitAll()
	        .and()
	       .logout()
	        .permitAll()
	       .and()
	       .csrf().disable();
	  
	  }
	 
	  	@Bean
	    @Override
	    public UserDetailsService userDetailsService() {
	        UserDetails user =
	             User.withDefaultPasswordEncoder()
	                .username("user")
	                .password("user")
	                .roles("member")
	                .build();

	        return new InMemoryUserDetailsManager(user);
	    }
	   



}
