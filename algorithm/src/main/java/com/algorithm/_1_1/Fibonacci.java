package com.algorithm._1_1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Fibonacci {

	private static Map<Integer,Long> Result = new ConcurrentHashMap<Integer, Long>(100);
	
	public static long F(int N) {
		if(N == 0 || N == 1) return N;
		
		if(!Result.containsKey(N - 1)) Result.put(N - 1, F(N - 1));
		if(!Result.containsKey(N - 2)) Result.put(N - 2, F(N - 2));
		
		return Result.get(N - 1) + Result.get(N - 2);
	}
	
	public static void main(String[] args) {
		
		for(int N = 0; N <10000000; N++)
			System.out.println("" + N + " : " + F(N));
		
	}

}
