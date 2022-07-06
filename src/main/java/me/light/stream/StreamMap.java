package me.light.stream;

import java.util.ArrayList;
import java.util.List;

import me.light.stream.domain.Person;

public class StreamMap {
	public static void main(String[] args) {
		List<Person> personList=new ArrayList<>();
		personList.add(new Person(1L, "홍길동", 10));
		personList.add(new Person(2L, "James", 32));
		personList.add(new Person(3L, "루니", 27));
	}
}
