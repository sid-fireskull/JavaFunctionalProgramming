package com.demo.practice;

import java.util.Comparator;
import java.util.List;


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

public class FunctionalProgramming2 {

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
		
		
//		1.	Sort by Review Score Reversed
		courses.stream().sorted(Comparator.comparing(Course::getReviewScore).reversed()).forEach(System.out::println);
//		2.	Sort by no. of students then by review score
		courses.stream().sorted(Comparator.comparingInt(Course::getNoOfStudents).thenComparing(Comparator.comparingInt(Course::getReviewScore))).forEach(System.out::println);
//		3.	Skip first 2 elements of the list
		courses.stream().skip(2).forEach(System.out::println);
//		4.	Limit the returned list up to 3 elements
		courses.stream().limit(3).forEach(System.out::println);
//		5.	Combining skip & limit methods
		courses.stream().skip(2).limit(3).forEach(System.out::println);
//		6.	Return elements up to a certain condition met
		courses.stream().takeWhile(e -> e.getReviewScore()>92).forEach(System.out::println);
//		7.	Drop all the elements in the list until the condition matches and go on
		courses.stream().dropWhile(e -> e.getReviewScore()>93).forEach(System.out::println);
//		8.	Last Element of the list after organizing by comparator
		System.out.println(courses.stream().max(Comparator.comparing(Course::getReviewScore)));
//		9.	First Element of the list after organizing by comparator
		System.out.println(courses.stream().min(Comparator.comparing(Course::getReviewScore)).orElse(new Course("Kubernetes", "Cloud", 91, 20000)));
//		10.	Get the first element which matches the condition
		System.out.println(courses.stream().filter(e -> e.getReviewScore() > 95).sorted(Comparator.comparing(Course::getName)).findFirst());
//		11.	Get any element which matches the condition
		System.out.println(courses.stream().filter(e -> e.getReviewScore() > 90).findAny());
//		12.	Total no. of students which match the condition
//		13.	Avg no. of students which match the condition
//		14.	Count no. of elements which match the condition
//		15.	Return Map by Grouping the output by category
//		16.	Get the list of Course Names only by category
//		17.	Check if all elements match a condition
//		18.	Check if none of the elements match a condition
//		19.	Check if any element matches a condition


	}

}
