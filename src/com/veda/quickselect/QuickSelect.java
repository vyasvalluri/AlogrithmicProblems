package com.veda.quickselect;

import java.util.Random;

public class QuickSelect {
	
	private int num[];
	
	QuickSelect(int num[]){
		this.num = num;
	}
	
	public int select(int k){
		return quickSelect(0, num.length-1, k-1);
	}
	
	private int quickSelect(int firstIdx, int lastIdx, int k) {
		
		int pivot = partition(firstIdx, lastIdx);
		
		if(pivot > k) {
			return quickSelect(firstIdx, pivot-1, k);	
		}if(pivot < k) {
			return quickSelect(pivot+1, lastIdx, k);
		}
		return num[k];
	}

	private int partition(int firstIdx, int lastIdx) {
		
		int pivot = new Random().nextInt(lastIdx-firstIdx+1) + firstIdx;
		swap(lastIdx, pivot);
		
		for(int i= firstIdx; i<lastIdx;i++) {
			if(num[i] > num[lastIdx]) {
				swap(i, firstIdx);
				firstIdx++;
			}
		}
		swap(firstIdx, lastIdx);
		return firstIdx;
	}

	private void swap(int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

}
