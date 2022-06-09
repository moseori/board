package me.light.service;

import java.util.List;

import me.light.model.Board;

public interface BoardService {
	List<Board> getList();

	Board get(Long bno);

	void insert(Board board);

	void update(Board board);

	void delete(Long bno);

	void modify(Board board);
}
