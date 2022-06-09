package me.light.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.light.mapper.BoardMapper;
import me.light.model.Board;
import me.light.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<Board> getList(Criteria criteria) {
		return boardMapper.getList(criteria);
	}

	@Override
	public Board get(Long bno) {
		return boardMapper.get(bno);
	}

	@Override
	public void insert(Board board) {
		boardMapper.insert(board);

	}

	@Override
	public void update(Board board) {
		boardMapper.update(board);

	}

	@Override
	public void delete(Long bno) {
		boardMapper.delete(bno);

	}
	
	@Override
	public void modify(Board board) {
		boardMapper.update(board);

	}

	@Override
	public void remove(Long bno) {
		boardMapper.delete(bno);
		
	}

	@Override
	public void register(Board board) {
		boardMapper.insert(board);
		
	}

	@Override
	public int totalCount() {
		return boardMapper.totalCount();
	}
}
