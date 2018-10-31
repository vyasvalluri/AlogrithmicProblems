package com.veda.recursion;

public class Test {

	public static void main(String[] args) {
		
		Recursion r = new Recursion();
		
		System.out.println("Iterative approach : "+ r.iterativeFactorial(5));
		System.out.println("Recursive approach :"+ r.recursionFactorial(1, 5));

	}

}
