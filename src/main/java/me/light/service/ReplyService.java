package me.light.service;

import java.util.List;

import me.light.model.Criteria;
import me.light.model.ReplyVO;

public interface ReplyService {
	List<ReplyVO> getList(Criteria criteria, Long bno);
	int register(ReplyVO vo);

	ReplyVO get(Long rno);

	int remove(Long rno);

	int modify(ReplyVO vo);

}
