package me.light;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test11 {


	@org.junit.Test
	public void test00() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		String formDate=sdf.format(date);
		System.out.println(formDate);
		String test = formDate.replace("-", File.separator);
		System.out.println(test);
	}

}
