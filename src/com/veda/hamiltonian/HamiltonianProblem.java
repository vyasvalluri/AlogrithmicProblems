package com.veda.hamiltonian;

/*
 *  Backtracking
 *  
 *  we use recursive to solve the problem
 *  create an empty path array and add vertex 0 to it as the starting vertex
 *  Add other vertices, starting from the vertex 1
 *  Before adding a vertex, check whether it is adjacent to the previously
 *  added vertex + make sure it is not already added
 *  If we find such a vertex -> we add the vertex as part of the solution
 *  If we do not find a vertex -> we return false
 */

public class HamiltonianProblem {
	
	int numOfVertices;
	int hamiltonianPath[];
	int hamiltonianGraph[][];
	
	public HamiltonianProblem(int hamiltonianGraph[][]) {
		this.hamiltonianGraph = hamiltonianGraph;
		this.hamiltonianPath = new int[hamiltonianGraph.length];
		this.numOfVertices = hamiltonianGraph.length;
		this.hamiltonianPath[0] = 0;
	}
	
	public void solve() {
		if(fisibleSolutionfind(1)) {
			showPath();
		} else {
			System.out.println(" there is no fisible solution found");
		}
	}

	private boolean fisibleSolutionfind(int position) {
		
		if(position == numOfVertices) {
			if(hamiltonianGraph[hamiltonianPath[position-1]][hamiltonianPath[0]] == 1)
				return true;
			else
				return false;
		}
		
		for(int vertexIdx = 1; vertexIdx < numOfVertices; vertexIdx++) {
			if (isFeasible(vertexIdx, position)) {
				hamiltonianPath[position] = vertexIdx;

				if (fisibleSolutionfind(position + 1)) {
					return true;
				}
				// Backtracking
			}
		}
		return false;
	}

	private boolean isFeasible(int vertexIdx, int position) {
		
		// first criterion : whether two nodes are connected?
		if(hamiltonianGraph[hamiltonianPath[position-1]][vertexIdx] == 0)
			return false;
		
		// second criterion : whether we have visited it or not
		for(int i=0; i<position;i++) {
			if(hamiltonianPath[i] == vertexIdx)
				return false;
		}
		return true;
	}

	private void showPath() {
		
		for(int i=0; i< hamiltonianPath.length; i++) {
			System.out.print(hamiltonianPath[i]+" -> ");
		}
		System.out.println();
	}

}
