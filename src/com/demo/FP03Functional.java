package com.demo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return "[+] Name: "+ name + " NoOfStudent:" + noOfStudents + " ReviewScore:" + reviewScore;
	}

}

public class FP03Functional {

	public static void main(String[] args) {
		List<Course> courses = List.of(
				new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), 
				new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), 
				new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), 
				new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));

		//matchMethod(courses);
		// customSort(courses);
		//organizeCustomListBasedOnCondition(courses);
		// organizeCustomMethod(courses);
		//customMathMethod(courses);
		groupMethod(courses);

	}
	
	
	private static void customSort(List<Course> courses) {
	
		// Sort by Review Score
		courses.stream().sorted(Comparator.comparing(Course::getReviewScore)).forEach(System.out::println);
		
		// Sort by Review Score Reversed
		courses.stream().sorted(Comparator.comparing(Course::getReviewScore).reversed()).forEach(System.out::println);
		
		// Sort by no. of student then by review score
		courses.stream().sorted(Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getReviewScore)).forEach(System.out::println);
	}
	
	private static void organizeCustomListBasedOnCondition(List<Course> courses)
	{
		// Skip first 2 element of the list
		courses.stream().skip(2).forEach(System.out::println);
		// limit the returned list upto 3 element
		courses.stream().limit(3).forEach(System.out::println);
		// Combining skip & limit method
		courses.stream().skip(2).limit(4).forEach(System.out::println);
		// Return elements upto certain condition met
		courses.stream().takeWhile(e -> e.getReviewScore() >= 95).forEach(System.out::println);
		// Drop all the element in the list until condition matches and go on
		courses.stream().dropWhile(e -> e.getReviewScore() >= 95).forEach(System.out::println);
	}
	
	private static void organizeCustomMethod(List<Course> courses)
	{
		// Last Element of the list after organize by comparator
		System.out.println(courses.stream().max(Comparator.comparing(Course::getReviewScore)).orElse(new Course("Azure", "Cloud", 99, 21000)));
		// First Element of the list after organize by comparator
		System.out.println(courses.stream().min(Comparator.comparing(Course::getReviewScore)).orElse(new Course("Azure", "Cloud", 99, 21000)));
		// Get First element which matches the condition
		System.out.println(courses.stream().filter(e -> e.getReviewScore()<95).findFirst());
		// Get any element which matches the condition
		System.out.println(courses.stream().filter(e -> e.getReviewScore()<95).findAny());
	}
	
	private static void customMathMethod(List<Course> courses)
	{
		// Total no. of student which matches the condition
		System.out.println(courses.stream().filter(e -> e.getReviewScore()>95).mapToInt(e -> e.getNoOfStudents()).sum());
		// Avg no. of student which matches the condition
		System.out.println(courses.stream().filter(e -> e.getReviewScore()>95).mapToInt(e -> e.getNoOfStudents()).average());
		// Count no. of element which matches the condition
		System.out.println(courses.stream().filter(e -> e.getReviewScore()>95).mapToInt(e -> e.getNoOfStudents()).count());
	}

	private static void groupMethod(List<Course> courses)
	{
		// Return Map by Grouping the output by category
//		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
//		// Return Max Review Score of each category
//		System.out.println(courses.stream()
//				.collect(Collectors.groupingBy(Course::getCategory, 
//						Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		// Get the list of Course Name only by category
		System.out.println(courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));
	}
	
	private static void matchMethod(List<Course> courses) {
		System.out.println("All Match: "+ courses.stream().allMatch(e -> e.getReviewScore() > 90));
		System.out.println("None Match: "+courses.stream().noneMatch(e -> e.getReviewScore() > 100));
		System.out.println("Any Match: "+courses.stream().anyMatch(e -> e.getReviewScore() > 95));
		
	}
	
	

}
