package me.light.paging;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.light.AppTest;
import me.light.mapper.BoardMapper;
import me.light.model.Board;

public class SerachData extends AppTest {

	@Autowired
	BoardMapper mapper;

	@Test
	@Ignore
	public void dataInsertTest1() {
		for (int i = 1; i <= 212; i++) {
			Board board = new Board();
			board.setTitle("페이징 처리 연습 : Spring" + i);
			board.setContents("내용 페이징 처리 연습 : Spring" + i);
			board.setWriter("홍길동" + i);
			mapper.insert(board);
		}
	}

	@Test
	public void dataInsertTest2() {
		for (int i = 1; i <= 212; i++) {
			Board board = new Board();
			board.setTitle("페이징 처리 연습 : Java" + i);
			board.setContents("내용 페이징 처리 연습 : Java" + i);
			board.setWriter("고길동" + i);
			mapper.insert(board);
		}
	}

}