package com.veda.search;

public class App {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 5, 7, 20, 35, 38, 48, 54 };
		Searching s = new Searching(arr);
		
		System.out.println("Linear Search : "+ s.iterativeSearch(35));
		System.out.println("Binary Search : "+ s.binarySearch(48));

	}

}
