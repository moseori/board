package me.light.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
@Import(value = {SecurityBean.class})
@ComponentScan("me.light.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthenticationSuccessHandler loginSuccessHandler; 

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	@Qualifier(value = "뽈롱")
	PasswordEncoder passwordEncoder; 

	@Autowired
	AuthenticationFailureHandler failureHandler; 
	
	@Autowired
	PersistentTokenRepository persistentTokenRepository;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/security/all").permitAll()
			.antMatchers("/security/admin").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/security/member").access("hasRole('ROLE_MEMBER')");

		http.formLogin()
			.loginPage("/customLogin")
			.usernameParameter("loginId")
			.passwordParameter("loginPw")
			.loginProcessingUrl("/member/login")
			.successHandler(loginSuccessHandler)
			.failureHandler(failureHandler);

		http.rememberMe().key("project").tokenRepository(persistentTokenRepository).tokenValiditySeconds(64800);
		
		http.logout()
			.logoutUrl("/customLogout")
			.invalidateHttpSession(true)
			.deleteCookies("remember-me","JSESSION_ID");
	}



}
