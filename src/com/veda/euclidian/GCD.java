package com.veda.euclidian;

public class GCD {
	
	public int iterativeGCD(int num1, int num2) {
		while(num2 !=0 ) {
			int temp = num2;
			num2 = num1 % num2;
			num1 = temp;
		}
		return num1;
	}
	
	public int recursiveGCD(int num1, int num2) {
		if(num2 == 0 ) return num1;
		
		return recursiveGCD(num2, num1 % num2);
	}

}
