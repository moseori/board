package me.light.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.light.mapper.BoardAttachMapper;
import me.light.mapper.BoardMapper;
import me.light.model.Board;
import me.light.model.BoardAttachVO;
import me.light.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Autowired
	private BoardAttachMapper attachMapper;
	
	@Override
	public List<Board> getList(Criteria criteria) {
		return boardMapper.getList(criteria);
	}

	@Transactional
	@Override
	public Board get(Long bno) {
		//boardMapper.addViewCount(bno);
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
	
	@Transactional
	@Override
	public void modify(Board board) {
		attachMapper.deleteAll(board.getBno());
		boardMapper.update(board);
		if (board.getAttachList() != null) {
			board.getAttachList().forEach(attach -> {
				attach.setBno(board.getBno());
				attachMapper.insert(attach);
			});
		}
	}

	@Transactional
	@Override
	public void remove(Long bno) {
		attachMapper.deleteAll(bno);
		boardMapper.delete(bno);
	}

	@Transactional
	@Override
	public void register(Board board) {
		boardMapper.insert(board);
		if(board.getAttachList()==null|| board.getAttachList().size()==0) return;
		board.getAttachList().forEach(attach ->{
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
		
	}

	@Override
	public int totalCount(Criteria criteria) {
		return boardMapper.totalCount(criteria);
	}

	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {
		return attachMapper.findByBno(bno);
	}
}
