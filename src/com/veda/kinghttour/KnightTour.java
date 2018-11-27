package com.veda.kinghttour;

public class KnightTour {
	
	public static final int BOARD_SIZE = 8;
	public static final int NO_OF_MOVES = 8;
	
	int [][]solutionMatrix;
	int xMoves[] = {2, 1, -1, -2, -2, -1, 1, 2};
	int yMoves[] = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public KnightTour() {
		this.solutionMatrix = new int[BOARD_SIZE][BOARD_SIZE];
		initializeBoard();
	}

	private void initializeBoard() {
		for(int i=0; i<BOARD_SIZE; i++) {
			for(int j=0; j<BOARD_SIZE; j++) {
				solutionMatrix[i][j] = Integer.MIN_VALUE;
			}
		}
		
	}
	
	public void solveTour() {
		solutionMatrix[0][0] = 0;
		
		if(solve(2,0,0)) {
			printSolution();
		} else {
			System.out.println("No fisible solution");
		}
	}

	private void printSolution() {
		for(int i=0; i<BOARD_SIZE; i++) {
			for(int j=0; j<BOARD_SIZE; j++) {
				System.out.print("  "+solutionMatrix[i][j]);
			}
			System.out.println();
		}
		
	}

	private boolean solve(int stepCount, int x, int y) {
		if(stepCount == BOARD_SIZE * BOARD_SIZE +1 )
			return true;
		for(int i=0; i<NO_OF_MOVES; i++) {
			int nextX = x + xMoves[i];
			int nextY = y + yMoves[i];
			
			if(isStepValid(nextX, nextY)) {
				solutionMatrix[nextX][nextY] = stepCount;
				if(solve(stepCount+1, nextX, nextY)) {
					return true;
				}
				
				// Backtracking
				solutionMatrix[nextX][nextY] = Integer.MIN_VALUE;
			}
		}
		return false;
	}

	private boolean isStepValid(int x, int y) {
		
		if( x < 0 || x >= BOARD_SIZE) return false;
		if( y < 0 || y >= BOARD_SIZE) return false;
		if(solutionMatrix[x][y] != Integer.MIN_VALUE)
			return false;
		return true;
	}

}
