package me.light.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import me.light.model.Criteria;
import me.light.model.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> getListAll();

	
	List<ReplyVO> getListWithPaging(@Param("cri") Criteria criteria, @Param("bno")Long bno);
	int insert(ReplyVO vo);

	ReplyVO read(Long rno);

	int delete(Long rno);

	int update(ReplyVO vo);
	
}
