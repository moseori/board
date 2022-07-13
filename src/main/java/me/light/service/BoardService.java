package me.light.service;

import java.util.List;

import me.light.model.Board;
import me.light.model.BoardAttachVO;
import me.light.model.Criteria;

public interface BoardService {
	List<Board> getList(Criteria criteria);

	Board get(Long bno, boolean isAddCount);

	void insert(Board board);

	void update(Board board);

	void delete(Long bno);

	void modify(Board board);

	void remove(Long bno);

	void register(Board board);

	int totalCount(Criteria criteria);
	
	List<BoardAttachVO> getAttachList(Long bno);
}
