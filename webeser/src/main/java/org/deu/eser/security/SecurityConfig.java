package org.deu.eser.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService service;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service).passwordEncoder(passwordEncoder());
	}

	/** @see WebSecurityConfigurerAdapter#configure(HttpSecurity) */
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		// http.authorizeRequests().antMatchers("login", "signup").permitAll();
		http.authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest().authenticated();
		http.formLogin().loginPage("/login").defaultSuccessUrl("/home");// .realmName("Beeride");
		http.csrf().disable();
		// http.sessionManagement().invalidSessionUrl("/timeout");
		http.logout().logoutUrl("/logout").invalidateHttpSession(true);
		http.userDetailsService(service);

		http.headers().cacheControl().and().xssProtection().and().frameOptions().and();
	}

	@Override
	public void configure(final WebSecurity web) throws Exception {
		final String[] ignoredPatterns = { "/signup", "/login" };
		web.ignoring().antMatchers(ignoredPatterns);
	}
}