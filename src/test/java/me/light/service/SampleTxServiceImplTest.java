package me.light.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.light.AppTest;

public class SampleTxServiceImplTest extends AppTest{

	@Autowired
	SampleTxService service;
	
	@Test
	public void testTx() {
		service.addData("HELLOWORLD");
	}

}
