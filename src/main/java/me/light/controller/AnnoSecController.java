package me.light.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import me.light.exception.NotMatchUserIdException;
import me.light.model.MemberVO;
import me.light.security.CustomUser;

@Controller
public class AnnoSecController {

	@PreAuthorize("hasAnyRole('ROLE_MEMBER','ROLE_ADMIN')")
	@GetMapping("/anno/member")
	public String memberPage() {
		return "member/member";
	}
	//마이페이지 
		@PreAuthorize("isAuthenticated()")
		@GetMapping("/anno/myPage/{userId}")
		public String myPage(@PathVariable String userId, @AuthenticationPrincipal CustomUser customUser, Model model) {
			MemberVO vo = customUser.getMemberVO();
			if (!vo.getUserId().equals(userId)) {
				//예외 발생
				System.out.println("예외 발생!");
				throw new NotMatchUserIdException();
			}
			model.addAttribute("member", vo);
			System.out.println(userId);
			return "member/myPage";
		}
}
