package com.veda.coloringproblem;

public class ColoringProblem {
	int numOfVertices;
	int numOfColors;
	int[] colors;
	int[][] adjancyMatrix;
	
	public ColoringProblem(int[][] adjancyMatrix, int numOfColors) {
		this.adjancyMatrix = adjancyMatrix;
		this.numOfVertices = adjancyMatrix.length;
		this.numOfColors = numOfColors;
		colors = new int[numOfVertices];
	}
	
	public void solve() {
		if(solveProblem(0)) {
			showResults();
		}else {
			System.out.println("No Feasible solution");
		}
	}

	private boolean solveProblem(int nodeIdx) {
		if(nodeIdx == numOfVertices) {
			return true;
		}
		
		for(int colorIdx=1; colorIdx<=numOfVertices; colorIdx++) {
			if(isColorValidI(nodeIdx, colorIdx)) {
				colors[nodeIdx] = colorIdx;
			}
			if(solveProblem(nodeIdx+1)) {
				return true;
			}
			
			// Backtracking
		}
		return false;
	}

	private boolean isColorValidI(int nodeIdx, int colorIdx) {
		for(int i=0; i<numOfVertices; i++) {
			if(adjancyMatrix[nodeIdx][i] == 1 && colorIdx == colors[i]) {
				return false;
			}
		}
		return true;
	}

	private void showResults() {
		for(int i=0; i< numOfVertices; i++) {
			System.out.println("Node "+(i+1)+" has color code "+colors[i]);
		}
			
		
	}

}
