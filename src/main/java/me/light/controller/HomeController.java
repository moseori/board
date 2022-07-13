package me.light.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String Home(HttpServletRequest request,  HttpServletResponse response) throws UnsupportedEncodingException {
		/*
		List<Board> boardList = new ArrayList<Board>();
		Board vo1 = new Board();
		vo1.setTitle("제목1");
		vo1.setWriter("작성자1");
		
		Board vo2 = new Board();
		vo2.setTitle("제목2");
		vo2.setWriter("작성자2");

		boardList.add(vo1);
		boardList.add(vo2);
		*/
		request.setCharacterEncoding("utf-8");
		Cookie cookie = new Cookie("myCookie", "쿠키먹고싶다");
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		return "home";
	}

}
