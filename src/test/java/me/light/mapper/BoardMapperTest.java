package me.light.mapper;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.light.AppTest;
import me.light.model.Board;

public class BoardMapperTest extends AppTest {

	@Autowired
	private BoardMapper mapper;
	@Autowired
	private DataSource dataSource;

	@Before
	public void setUp() throws IOException, SQLException {
		Reader reader = Resources.getResourceAsReader("sql/sql_board.sql");
		ScriptRunner runner = new ScriptRunner(dataSource.getConnection());
		runner.runScript(reader);
	}

	@Test
	public void getListTest() {
		List<Board> list = mapper.getList();
		assertEquals(4, list.size());
	}

	@Test
	public void getTest() {
		Board board = mapper.get(1L);
		assertEquals("게시물 제목입니다", board.getTitle());
		assertEquals("내용 테스트입니다.", board.getContents());
		assertEquals("테스트", board.getWriter());
	}

	@Test
	public void insertTest() {
		Board board = new Board();
		board.setTitle("제목 테스트임");
		board.setContents("내용 테스트임");
		board.setWriter("작성자");
		mapper.insert(board);
		Board getBoard = mapper.get(5L);

		assertEquals(board.getTitle(), getBoard.getTitle());
		assertEquals(board.getContents(), getBoard.getContents());
		assertEquals(board.getWriter(), getBoard.getWriter());
	}

}
