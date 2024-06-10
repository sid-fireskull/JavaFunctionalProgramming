package com.demo.inheritence;

public class PolyMorphisimAnimal {

	public static void main(String[] args) {
		Animal a = new Dog();
		a.shout();
		// Not possible until the reference variable should be the same type of the object
		//a.run();
	}

}
