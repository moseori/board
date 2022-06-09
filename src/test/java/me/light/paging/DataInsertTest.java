package me.light.paging;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.light.AppTest;
import me.light.mapper.BoardMapper;
import me.light.model.Board;

public class DataInsertTest extends AppTest{

	@Autowired
	BoardMapper mapper;
	
	@Test
	public void dataInsertTest() {
		for (int i = 1; i <= 412; i++) {
			Board board = new Board();
			board.setTitle("페이징 처리 연습" + i);
			board.setContents("내용 페이징 처리 연습" + i);
			board.setWriter("작성자" + i);
			mapper.insert(board);
		}
	}

}
