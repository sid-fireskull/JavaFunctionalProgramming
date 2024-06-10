package com.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FP07FunctionalFiles {

	public static void main(String[] args) throws IOException {
		// Reading File and convert it to stream
		Files.lines(Paths.get("file.txt")).forEach(System.out::println);
		
		// Find out distinct word form the file
		Files.lines(Paths.get("file.txt")).map(e -> e.split(" "))
		.flatMap(Arrays::stream)
		.distinct().sorted()
		.forEach(System.out::println);
		
		// Get list of all directory in certain directory
		Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);

	}

}
