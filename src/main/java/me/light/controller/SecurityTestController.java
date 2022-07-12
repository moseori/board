package me.light.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityTestController {

	@GetMapping("/all")
	public String doAll() {
		System.out.println("모든 방문자");
		return "member/all";
	}

	@GetMapping("/member")
	public String doMember() {
		System.out.println("회원");
		return "member/member";
	}

	@GetMapping("/admin")
	public String doAdmin() {
		System.out.println("관리자");
		return "member/admin";
	}
}
