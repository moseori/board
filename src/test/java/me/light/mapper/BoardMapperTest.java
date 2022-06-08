package me.light.mapper;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.light.AppTest;
import me.light.model.Board;

public class BoardMapperTest extends AppTest{

	@Autowired
	private BoardMapper mapper;

	@Test
	public void getListTest() {
		List<Board> list= mapper.getList();
		assertEquals(4, list.size());
	}

}
