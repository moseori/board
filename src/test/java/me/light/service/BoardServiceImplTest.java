package me.light.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.light.AppTest;
import me.light.model.Board;

public class BoardServiceImplTest extends AppTest {

	@Autowired
	BoardService service;

	@Test
	public void getListTest() {
		List<Board> list = service.getList();
		assertEquals(4, list.size());
	}

}
