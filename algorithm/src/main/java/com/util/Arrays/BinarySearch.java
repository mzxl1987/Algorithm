package com.util.Arrays;

public class BinarySearch {

	/**
	 * 
	 * @param key
	 * @param a   必须是有序数组
	 * @return
	 */
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
	
	/**
	 * 
	 * @param key
	 * @param a   必须是有序数组
	 * @return
	 */
	public static int rank(int key, int[] a,int lo,int hi,int deep){
		if(lo > hi) return -1;
		
		int mid = lo + ((hi - lo) >>> 1);
		if          (key > a[mid])  lo = mid + 1;
		else if     (key < a[mid])  hi = mid - 1;
		else                       return mid;
		
		int i = 0;
		System.out.print("+");
		while(i++ < deep) System.out.print("-");
		
		System.out.println(" lo:" + lo + ",hi:" + hi + ",deep:" + deep);
		return rank(key,a,lo,hi,++deep);
	}
	
	public static void main(String[] args) {
		
		int[] test = {0,1,2,3,4,5,6,7,8,9,10};
		System.out.println(BinarySearch.rank(0, test,0,test.length - 1,0));

	}

}
