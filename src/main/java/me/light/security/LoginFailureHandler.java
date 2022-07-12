package me.light.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginFailureHandler implements AuthenticationFailureHandler{

	private String loginId; 
	private String loginPw; 
	private String errorMessage; 
	private String defaultFailureUrl;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		System.out.println("로그인실패!!!");
		String username = request.getParameter(loginId);
		String password = request.getParameter(loginPw);
		String errorMsg = request.getParameter(errorMessage);

		System.out.println(username);
		System.out.println(password);
		System.out.println(errorMsg);
		
		request.setAttribute(loginId, username);
		request.setAttribute(loginPw, password);
		request.setAttribute(errorMessage, errorMsg);

		request.getRequestDispatcher(defaultFailureUrl)
				.forward(request, response);
	}

}
