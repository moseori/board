package me.light.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import me.light.mapper.ReplyMapper;
import me.light.model.Criteria;
import me.light.model.ReplyVO;

@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	private ReplyMapper mapper;
	
	@Override
	public List<ReplyVO> getList(Criteria criteria, Long bno) {
		return mapper.getListWithPaging(criteria, bno);
	}

	@Override
	public int register(ReplyVO vo) {
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		return mapper.read(rno);
	}

	@Override
	public int remove(Long rno) {
		return mapper.delete(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		return mapper.update(vo);
	}

}
