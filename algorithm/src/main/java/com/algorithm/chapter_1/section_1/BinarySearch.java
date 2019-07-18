package com.algorithm.chapter_1.section_1;

import com.algorithm.chapter_1.section_2.Counter;

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
	
	/**
	 * 1.2.9
	 * @param key
	 * @param a
	 * @param lo
	 * @param hi
	 * @param count
	 * @return
	 */
	public static int rank(int key, int[] a,int lo, int hi, Counter count){
		if(lo > hi) return -1;
		
		int mid = lo + ((hi - lo) >>> 1);
		if          (key > a[mid])  lo = mid + 1;
		else if     (key < a[mid])  hi = mid - 1;
		else                       return mid;
		
		count.increment();
		return rank(key,a,lo,hi,count);
	}
	
	public static void main(String[] args) {
		
		int[] test = {0,1,2,3,4,5,6,7,8,9,10};
		Counter count = new Counter("BS");
		BinarySearch.rank(0, test,0,test.length - 1,count);
		System.out.println(count);

	}

}
