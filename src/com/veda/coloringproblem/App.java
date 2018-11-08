package com.veda.coloringproblem;

public class App {

	public static void main(String[] args) {
		
		int [][] adjancyMatrix = new int [][] {
			{0,1,0,1,0},
			{1,0,1,1,0},
			{0,1,0,1,0},
			{1,1,1,0,1},
			{0,0,0,1,0}
		};
		
		int numOfColors = 3;

		ColoringProblem cp = new ColoringProblem(adjancyMatrix, numOfColors);
		cp.solve();
	}

}
