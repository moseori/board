package me.light.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logadvice {

	@Before("execution(* me.light.service.*.doAdd(String,String))&&args(str1,str2)")
	public void logBefore(String str1, String str2) {
//		System.out.println("=================");
//		System.out.println("첫번째 파라메터 : "+ str1);
//		System.out.println("두번째 파라메터 : "+ str2);
	}

	@Around("execution(* me.light.service.*.doAdd(String,String))")
	public Object logTime(ProceedingJoinPoint joinPoint) {
		System.out.println("시작 시간 설정");

		long start = System.currentTimeMillis();

		Object result = null;
		try {
			result = joinPoint.proceed(); //doAdd메소드 호출
		} catch (Throwable e) {
			e.printStackTrace();
		}

		System.out.println("도달 시간 설정");
		long end = System.currentTimeMillis();
		System.out.println("걸린 시간 : " + (end - start));
		return result;
	}

}
