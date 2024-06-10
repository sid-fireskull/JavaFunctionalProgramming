package com.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP05FunctionalJoining {

	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "FullStack", "AWS", "Azure",
				"Docker", "Kubernetes");

		List<String> course2 = List.of("Spring", "Spring Boot", "API", "Microservices", "FullStack", "AWS", "Azure",
				"Docker", "Kubernetes");

		// Join the array using stream with , between
		System.out.println(courses.stream().collect(Collectors.joining(", ")));

		// Stream of String[] -> Stream of String
		System.out.println(courses.stream().map(e -> e.split("")).flatMap(Arrays::stream).collect(Collectors.toList()));

		// Get Unique pair using flatmap
		System.out.println(courses.stream().flatMap(course -> course2.stream().map(e -> List.of(course, e)))
				.filter(list -> list.get(0).equals(list.get(1))).collect(Collectors.toList()));

	}

}
