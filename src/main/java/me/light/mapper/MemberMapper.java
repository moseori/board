package me.light.mapper;

import me.light.model.MemberVO;

public interface MemberMapper {

	MemberVO read(String userId);
}
