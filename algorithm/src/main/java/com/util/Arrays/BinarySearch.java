package com.util.Arrays;

public class BinarySearch {

	public static int rank(int key, int[] a){
		int lo = 0;
		int hi = a.length - 1;
		while(lo <= hi){
			int mid = lo + ((hi - lo) >>> 1);
			if          (key > a[mid]) lo = mid + 1;
			else if     (key < a[mid]) hi = mid - 1;
			else                       return mid;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		int[] test = {1,2,3,4,5,6,7,8,9,0};
		System.out.println(BinarySearch.rank(0, test));

	}

}
