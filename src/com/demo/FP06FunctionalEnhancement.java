package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

public class FP06FunctionalEnhancement {

	public static void main(String[] args) {
		List<String> c = List.of("Spring", "Spring Boot", "API", "Microservices", "FullStack", "AWS", "Azure",
				"Docker", "Kubernetes");
		List<String> courses = new ArrayList<>(c);

		// Parallel computing enhancement for stream
		long time = System.currentTimeMillis();
		LongStream.range(1, 1000000000).sum();
		System.out.println("Time taken during single thread execution: " + (System.currentTimeMillis() - time));

		long time2 = System.currentTimeMillis();
		LongStream.range(1, 1000000000).parallel().sum();
		System.out.println("Time taken during Parallel thread execution: " + (System.currentTimeMillis() - time2));
		
		// Replace All string using functional programming to upper case of same string
		courses.replaceAll(e -> e.toUpperCase());
		System.out.println(courses);
		
		// Removing element using functional programming if the list length is less than 6
		courses.removeIf(e -> e.length() < 6);
		System.out.println(courses);
	}

}
