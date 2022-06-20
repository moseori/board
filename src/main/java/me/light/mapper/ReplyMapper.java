package me.light.mapper;

import java.util.List;

import me.light.model.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> getListAll();
	int insert(ReplyVO vo);
	ReplyVO read(Long rno);
	int delete(Long rno);
	int update(ReplyVO vo);
}
