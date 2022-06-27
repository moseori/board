package me.light.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logadvice {

	@Before("execution(* me.light.service.SampleService*.doAdd(String,String))&&args(str1,str2)")
	public void logBefore(String str1, String str2) {
		System.out.println("=================");
		System.out.println("첫번째 파라메터 : "+ str1);
		System.out.println("두번째 파라메터 : "+ str2);
	}

}
