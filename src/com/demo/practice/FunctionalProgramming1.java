package com.demo.practice;

import java.util.Comparator;
import java.util.List;

public class FunctionalProgramming1 {

	public static void main(String[] args)
	{
		List<Integer> numbers = List.of(12, 4, 5, 9, 22, 34, 7, 22, 12, 244);
		List<String> courses = List.of("Spring MVC", "Spring Boot", "Javascript", "Spring Batch", "Java", "Python","Flask");
		
		//		1.	Sort the number
		numbers.stream().sorted().forEach(System.out::println);
		
		//		2.	Sort and return unique number
		numbers.stream().distinct().sorted().forEach(System.out::println);
		
		//		3.	Custom sort for strings
		courses.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
		
		//		4.	Sum of the numbers
		System.out.println(numbers.stream().reduce(0, Integer::sum));
		
		//		5.	Calculate Square of each element in the list
		numbers.stream().map(e -> e*e).forEach(System.out::println);
		
		//		6.	Filter words containing "Spring"
		courses.stream().filter(e -> e.toLowerCase().contains("spring")).forEach(System.out::println);
		
		//		7.	List even numbers
		numbers.stream().filter(e -> e % 2==0).forEach(System.out::println);
		
		//		8.	Calculate sum of numbers square
		System.out.println(numbers.stream().map(e -> e*e).reduce(0, Integer::sum));
		
		//		9.	Sum of even numbers in the list
		System.out.println(numbers.stream().filter(e -> e % 2 == 0).reduce(0, Integer::sum));

	
	}
	
}
