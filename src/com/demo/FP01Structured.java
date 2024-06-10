package com.demo;

import java.util.Comparator;
import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 4, 5, 9, 22, 34, 7,22, 12, 244);
		List<String> courses = List.of("Spring MVC", "Spring Boot", "Javascript", "Spring Batch", "Java", "Python",
				"Flask");
//		filterSpring(courses);
//		calculateSquare(numbers);
//		isEven(numbers);
//		calculateSum(numbers);
//		calculateSquareSum(numbers);
//		sumOfEvenNumbers(numbers);
		sortNumbers(numbers);
		uniquesortNumbers(numbers);
		customSortString(courses);
	}

	// Sort the number
	private static void sortNumbers(List<Integer> numbers) {
		numbers.stream().sorted().forEach(System.out::println);
	}
	// Sort and return unique number
	private static void uniquesortNumbers(List<Integer> numbers) {
		numbers.stream().distinct().sorted().forEach(System.out::println);
	}
	
	private static void customSortString(List<String> courses) {
		//courses.stream().distinct().sorted().forEach(System.out::println);
		//courses.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		courses.stream().distinct().sorted(Comparator.comparing(e -> e.length())).sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
	
	

	private static Integer sum(int aggregate, int nextNumber)
	{
		return aggregate+nextNumber;
	}
	
	// Sum of the result
	private static void calculateSum(List<Integer> numbers) {
		int result =numbers.stream()
		// Reduce used to reduce the list using specified logic by method references		
		//.reduce(0, FP01Structured::sum); 
		//.reduce(0, (x,y) -> x + y);
		.reduce(0, Integer::sum);
		System.out.println("Total: "+ result);
	}
	
	// Calculate Square of each element in the list
	private static void calculateSquare(List<Integer> numbers) {
		numbers.stream()
		.map(e -> e * e) // Convert each element with desired logic
		.forEach(System.out::println);
	}

	// Filter Word
	private static void filterSpring(List<String> courses) {
		courses.stream()
		.filter(e -> e.toLowerCase().contains("spring"))
		.forEach(System.out::println);

	}
	// List Even Number
	static void isEven(List<Integer> numbers) {
		numbers.stream().filter(element -> element % 2 == 0) // Filter only even using Lambda Expression
				.forEach(System.out::println); // Method Reference
	}
	
	// Calculate sum of numbers square
	static void calculateSquareSum(List<Integer> numbers)
	{
		int result =numbers.stream().map(e -> e * e).reduce(0,Integer::sum);
		System.out.println("Total: "+ result);
	}
	
	// Sum of even number in the list
	static void sumOfEvenNumbers(List<Integer> numbers)
	{
		int result =numbers.stream().filter(e -> e%2==0).reduce(0,Integer::sum);
		System.out.println("Total (Even Numbers): "+ result);
	}
	
	

}
