package com.veda.nqueens;

public class NQueensProblem {
	
	int[][] board;
	int numOfQueens;
	
	public NQueensProblem(int numOfQueens) {
		this.board = new int[numOfQueens][numOfQueens];
		this.numOfQueens = numOfQueens;
	}
	
	public void solve() {
		if(setQueenAt(0)) {
			printBoard();
		}else {
			System.out.println("thre is no feasible solution");
		}
			
	}

	private void printBoard() {
		for(int i = 0; i< numOfQueens; i++) {
			for(int j = 0; j < numOfQueens; j++) {
				if(board[i][j] == 1)
					System.out.print(" * ");
				else
					System.out.print(" - ");
			}
			System.out.println();
		}
		
	}

	private boolean setQueenAt(int colIdx) {
		
		if(colIdx == numOfQueens) {
			return true;
		}
		
		for(int rowIdx=0; rowIdx<numOfQueens; rowIdx++) {
			if(isValidPlace( rowIdx, colIdx)) {
				board[rowIdx][colIdx] = 1;
				
				if(setQueenAt(colIdx+1)) {
					return true;
				}
				
				// backtracking
				board[rowIdx][colIdx] = 0;
			}
		}
		return false;
	}

	private boolean isValidPlace(int rowIdx, int colIdx) {
		
		for(int i=0; i<colIdx; i++) {
			if(board[rowIdx][i]== 1)
				return false;
		}
		for(int i=rowIdx, j=colIdx; i>=0 && j>=0; i--, j--) {
			if(board[i][j] == 1)
				return false;
		}
		for(int i=rowIdx, j=colIdx; i < board.length && j>=0; i++, j--)
			if(board[i][j] == 1)
				return false;
		return true;
	}

}
