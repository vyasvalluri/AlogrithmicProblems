package com.veda.quickselect;

public class App {

	public static void main(String[] args) {
		int num[] = {10, 4, 5, 6, 3, 9,22, 34};

		QuickSelect obj = new QuickSelect(num);
		System.out.println("larget Element "+ obj.select(3));
	}

}
