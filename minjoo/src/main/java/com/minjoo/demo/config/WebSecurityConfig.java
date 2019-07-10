package com.minjoo.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.minjoo.demo.security.customLoginSuccessHandler;

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
	    public UserDetailsService userDetailsService(){
	        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("user").roles("MEMBER").build());
	        manager.createUser(User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN").build());
	        return manager;
	    }

	   



}
