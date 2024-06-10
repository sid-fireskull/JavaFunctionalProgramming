package com.demo;

public class Test {
	static int count=4;
	int i;
//	static {
//		count = 4;
//		count++;
//		System.out.println(count);
//	}
	
	{
		i=2;
		count = count+i;
		System.out.println(count);
	}
	
	public int getCount()
	{
		return count;
		
	}

	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = new Test();
		Test t3 = new Test();
		t3.getCount();
	}

}
