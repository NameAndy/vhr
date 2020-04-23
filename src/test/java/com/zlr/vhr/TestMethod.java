package com.zlr.vhr;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

public class TestMethod {
	
	@Test
	public void bianli() {
		
		List<String> asList = Arrays.asList("nihao","tamen","haiyou");
		
		asList.forEach(a -> System.out.println(a));
		asList.forEach(System.out::println);
		asList.forEach(TestMethod::helo);
		
		List<Person> persons = Arrays.asList(new Person("10"),new Person("13"),new Person("89"));
		
		persons.forEach(a -> System.out.println(a));
		persons.forEach(System.out::println);
		persons.forEach(Person::getA);
		
	}
	
	public  static void helo(String nihao) {
		System.out.println(nihao);

	}
	public   void hi() {
		System.out.println("hi");
		
	}

	public class Person{
		
		
		@Override
		public String toString() {
			return "Person [age=" + age + "]";
		}

		private Person() {
			super();
		}
		
		public void getA() {
			System.out.println("jinlai");
		}

		public Person(String age) {
			super();
			this.age = age;
		}

		private String age;

		public String getAge() {
			return age;
		}
		
		public void setAge(String age) {
			this.age = age;
		}
		
		
	}
}
