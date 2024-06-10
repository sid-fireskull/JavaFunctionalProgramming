package com.demo;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP02Functional {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 4, 5, 9, 22, 34, 7,22, 12, 244);
		List<String> courses = List.of("Spring MVC", "Spring Boot", "Javascript", "Spring Batch", "Java", "Python",
				"Flask");
		
		Predicate<Integer> predicate = new Predicate<Integer>() {
			
			@Override
			public boolean test(Integer x) {
				return x % 2 == 0;
			}
		};
		
		Function<Integer, Integer> mapper = new Function<Integer, Integer>() {
			
			@Override
			public Integer apply(Integer x) {
				return x * x;
			}
		};
		
		Consumer<Integer> action = new Consumer<Integer>() {
			
			@Override
			public void accept(Integer t) {
				System.out.println(t);
				
			}
		};
		numbers.stream()
		.filter(predicate)
		.map(mapper)
		.forEach(action);
		
		BinaryOperator<Integer> accumulator = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				return Integer.sum(t, u);
			}
		};
		numbers.stream().reduce(0, accumulator);

	}

}
