package me.light.mapper;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.light.AppTest;

public class TotalCountTest extends AppTest{
	
	@Autowired
	BoardMapper mapper;

	@Test
	public void test() {
		assertEquals(416, mapper.totalCount());
	}

}
