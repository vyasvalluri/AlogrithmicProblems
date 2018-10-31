package com.veda.towersofhonai;

public class TowersOfHonai {
	
	public void solveHonai(int n, char start, char middle, char end) {
		
		if(n == 1 ) {
			System.out.println("plate 1 from "+ start + " to "+ end);
			return;
		}
		
		// we have to move n-1 plates to middle 
		solveHonai(n-1, start, end, middle);
		// we have to move nth plate to last 
		System.out.println("plate "+n+ " from "+ start+" end "+end);
		// we have to move n-1 plate to last with the help of 1st( 1st is axilary in this case)
		solveHonai(n-1, middle, start, end);
	}

}
