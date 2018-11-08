package com.veda.hamiltonian;

public class App {

	public static void main(String[] args) {
		int [][]hamiltonianGraph = {
				{0,1,1,1,0,0},
				{1,0,1,0,1,0},
				{1,1,1,1,0,1},
				{1,0,1,0,0,1},
				{0,1,0,0,0,1},
				{0,1,1,1,1,1}
		};
		HamiltonianProblem hp = new HamiltonianProblem(hamiltonianGraph);
		hp.solve();

	}

}
