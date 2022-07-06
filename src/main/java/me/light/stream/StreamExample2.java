package me.light.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamExample2 {
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add("홍길동");
		list.add("길동");
		list.add("고");
		list.add("스트림 생성");
		
		//스트림 생성
		Stream<String> stream=list.stream();
		
		//파라메터로 익명 구현 객체 전달
		stream.forEach((e) ->{
				System.out.println(e);
				System.out.println("길이 : "+e.length());
				System.out.println("===================");
		});
		
		//중괄호 내 코드가 한 줄인 경우
		//중광호 생략 가능 -> 세미콜론 반드시 삭제해야함
		//stream2.forEach(e->System.out.println(e));

		list.stream().forEach(e->System.out.println(e));
		System.out.println("---------------------");
		
		//메소드 참조
		System.out.println("메소드 참조");
		list.stream().forEach(System.out::println);
	}

}
