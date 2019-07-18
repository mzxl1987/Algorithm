package com.algorithm._1_1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Binomial {

	private static Map<String,Double> NK = new ConcurrentHashMap<String, Double>(100);
	
	public static double binomial(int N, int k,double p) {
		
		if(N == 0 && k == 0) return 1.0;
		if(N < 0 || k < 0) return 0;
		
		final String key =  "" + N + ":" + k;
		if(!NK.containsKey(key)) NK.put(key, (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1, k - 1, p));
		
		return NK.get(key);
		
	}
	
	public static void main(String[] args) {
		
			System.out.println(binomial(1000, 500, 0.25));
		
	}

}
