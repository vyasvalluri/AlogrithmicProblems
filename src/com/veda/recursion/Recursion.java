package com.veda.recursion;
public class Recursion {
	
	public int iterativeFactorial(int n) {
		
		int fact = 1;
		for(int i=1; i<=n; i++) {
			fact = fact * i;
		}
		return fact;
	}
	
	public int recursionFactorial( int accumlatlor, int n) {
		if(n == 1) return accumlatlor;
		return recursionFactorial(accumlatlor*n, n-1);
	}

}
