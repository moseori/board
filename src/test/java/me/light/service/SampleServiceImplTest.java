package me.light.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.light.AppTest;

public class SampleServiceImplTest extends AppTest {

	@Autowired
	SampleService service;

	@Test
	public void test() throws Exception {
		Integer odAdd = service.doAdd("10", "12");
		System.out.println(odAdd);
	}

}
