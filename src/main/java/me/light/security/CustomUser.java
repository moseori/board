package me.light.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import me.light.model.MemberVO;

public class CustomUser extends User{
	
	private MemberVO memberVO;

	private static final long serialVersionUID = 1L;
	public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	public CustomUser( MemberVO memberVO) {
		super(memberVO.getUserId(), memberVO.getUserPw(), memberVO.getAuthList().stream().map(vo->new SimpleGrantedAuthority(vo.getAuth())).collect(Collectors.toList()));
		this.memberVO = memberVO;
	}
	
	
	


}
