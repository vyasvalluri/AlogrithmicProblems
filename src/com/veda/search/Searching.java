package com.veda.search;

public class Searching {
	
	private int array[];
	
	Searching(int a[]){
		this.array = a;
	}
	
	public int iterativeSearch(int item){
		for (int i=0; i<array.length; i++) {
			if(array[i] == item)
				return i;
		}
		return -1;
	}
	
	private int binarySearch(int startIdx, int endIdx, int item) {
		
		if(endIdx < startIdx ) {
			return -1;
		}
		 int middleIdx = ( startIdx + endIdx ) / 2;
		 if(array[middleIdx] == item)
			 return middleIdx;
		 else if(array[middleIdx] < item)
			 return binarySearch(middleIdx+1, endIdx, item);
		 else
			 return binarySearch(startIdx, middleIdx-1, item);
	}
	
	public int binarySearch(int item) {
		return binarySearch(0, array.length, item);
	}
	

}
