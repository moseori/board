package me.light.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import me.light.security.CustomLoginSuccessHandler;
import me.light.security.CustomNoopPasswordEncoder;
import me.light.security.CustomUserDetailService;

@Configuration
public class SecurityBean {

	//<bean id="bCryptPasswordEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"></bean>
	//<bean id="cutomUserDetailService" class="me.light.security.CustomUserDetailService"></bean>
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailService();
	}
	
	public PasswordEncoder bcryptPwEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public PasswordEncoder noopEncoder() {
		return new CustomNoopPasswordEncoder();
	}
}
