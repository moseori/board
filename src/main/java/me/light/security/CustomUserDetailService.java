package me.light.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import me.light.mapper.MemberMapper;
import me.light.model.MemberVO;

public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	MemberMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO memberVO=mapper.read(username);
		return memberVO != null? new CustomUser(memberVO): null;
	}

}
