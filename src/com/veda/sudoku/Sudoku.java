package com.veda.sudoku;

public class Sudoku {
	
	public static final int BOARD_SIZE = 9;
	public static final int MIN_NUM = 1;
	public static final int MAX_NUM = 9;
	public static final int BOX_SIZE = 3;
	
	private int sudokuTable[][];
	
	public Sudoku(int sudokuTable[][]) {
		this.sudokuTable = sudokuTable;
	}
	
	public void SolveProblem() {
		if(solve(0,0)) {
			showResults();
		} else {
			System.out.println(" No solution ");
		}
	}

	private void showResults() {
		
		for(int i=0; i<BOARD_SIZE; i++) {
			if(i %3 == 0) System.out.println("  ");
			for(int j=0; j<BOARD_SIZE; j++) {
				if(j % 3 == 0) System.out.print("  ");
				System.out.print(sudokuTable[i][j]+ " ");
			}
			System.out.println("");
		}
		
	}

	private boolean solve(int rowIdx, int colIdx) {
		if(rowIdx == BOARD_SIZE && ++colIdx == BOARD_SIZE)
			return true;
		if(rowIdx == BOARD_SIZE)
			rowIdx = 0;
		if(sudokuTable[rowIdx][colIdx] !=0 )
			return solve(rowIdx+1, colIdx);
		
		for(int num=MIN_NUM; num<= MAX_NUM; ++num) {
			if(isValid(rowIdx, colIdx, num)) {
				sudokuTable[rowIdx][colIdx] = num;
				if(solve(rowIdx+1, colIdx))
					return true;
			}
		}
		//back tracking
		sudokuTable[rowIdx][colIdx] = 0;
		return false;
	}

	private boolean isValid(int rowIdx, int colIdx, int num) {
		// if the given number is already in the row: the num can not 
		// be part of solution
		for(int i=0; i< BOARD_SIZE; i++) {
			if(sudokuTable[i][colIdx] == num)
				return false;
		}
		
		// if the given number is already in the column: the num can not
		// be part of solution
		for(int j=0; j < BOARD_SIZE; j++) {
			if(sudokuTable[rowIdx][j] == num)
				return false;
		}
		
		// if the given number is already in the box: the number can not 
		// be part of solution
		int boxRowOffset = (rowIdx / 3) * BOX_SIZE;
		int boxColOffset = (colIdx / 3) * BOX_SIZE;
		
		for(int i=0; i < BOX_SIZE; i++)
			for(int j = 0; j < BOX_SIZE; j++)
				if(num == sudokuTable[boxRowOffset +i][boxColOffset + j])
					return false;
		
		return true;
	}

}
