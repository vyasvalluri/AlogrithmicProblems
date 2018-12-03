package com.veda.maze;

public class MazeProblem {

	private int [][]mazeTable;
	private int mazeSize;
	private int [][]solutionTable;
	
	public MazeProblem(int [][]mazeTable) {
		this.mazeTable = mazeTable;
		this.mazeSize = mazeTable.length;
		this.solutionTable = new int[mazeSize][mazeSize];
	}
	
	public void printSolution() {
		for(int i=0; i<mazeSize; i++) {
			for(int j=0; j<mazeSize; j++) {
				if(solutionTable[i][j] == 1) {
					System.out.print(" S ");
				}else
					System.out.print(" - ");
			}
			System.out.println();
		}
	}
	
	public void solve() {
		if(solveMaze(0,0)) {
			printSolution();;
		}else {
			System.out.println("");
		}
	}

	private boolean solveMaze(int x, int y) {
		
		if(isFinished(x,y))
			return true;
		if(isValid(x,y)) {
			solutionTable[x][y] = 1;
			if(solveMaze(x+1, y))
				return true;
			if(solveMaze(x, y+1))
				return true;
			
			//backtracking
			solutionTable[x][y] = 0;
		}
		
		return false;
	}

	private boolean isValid(int x, int y) {
		if(x<0 || x>=mazeSize) return false;
		if(y<0 || y>=mazeSize) return false;
		if(mazeTable[x][y] != 1) return false;
		return true;
	}

	private boolean isFinished(int x, int y) {
		if(x == mazeSize -1 && y == mazeSize -1) {
			solutionTable[x][y] = 1;
			return true;
		}
			
		return false;
	}
}
