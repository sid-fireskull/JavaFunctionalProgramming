package com.demo;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FP04FunctionalCalculation {

	public static void main(String[] args) {
		//defineStream();
		//generateDataUsingStream();
		handlingBigValue();

	}

	private static void defineStream() {
		// This is a reference type of array with wrapper class Integer so boxing &  unboxing takes time 
		System.out.println(Stream.of(1,2,4,8,44, 14,13)); 
		// Better way to define the same array by Primitive, this also open the possibility to do multiple task like sum, average, min etc
		int[] numArray = new int[]{1,4,8,3, 44, 56, 7, 9};
		System.out.println(Arrays.stream(numArray));
		
		System.out.println(Arrays.stream(numArray).sum());
	}
	
	private static void generateDataUsingStream()
	{
		// Generate stream of numbers 1-9
		IntStream.range(1, 10).forEach(System.out::println);
		// Generate stream of numbers 1-10
		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		// Generate stream of numbers with specific sequence
		IntStream.iterate(1, e -> e+2).limit(10).forEach(System.out::println);
		// Calculating Sum with generated no. in specific sequence with peek method to print the sequence
		System.out.println(IntStream.iterate(1, e -> e + 2).limit(10).peek(System.out::println).sum());
		// Calculating sum of x^2 , where x is the element of the stream
		System.out.println(IntStream.iterate(2, e -> e * 2).limit(10).peek(System.out::println).sum());
		// Collect primitive int into list [boxed is used to convert primitive type to Integer wrapper class]
		System.out.println(IntStream.iterate(2, e -> e*2).limit(10).boxed().collect(Collectors.toList()));
	}
	
	private static void handlingBigValue()
	{
		System.out.println(IntStream.range(1, 10).reduce(1, (x,y)-> x*y));
		System.out.println(LongStream.range(1, 30).reduce(1L, (x,y) -> x*y));
		System.out.println(LongStream.range(1, 50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));
	}
	
	

}
