package com.veda.euclidian;

public class Test {

	public static void main(String[] args) {
		GCD obj = new GCD();
		System.out.println("Iterative : "+obj.iterativeGCD(40, 100));
		System.out.println("Recursive : "+obj.recursiveGCD(100, 40));
	}

}
