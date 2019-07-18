package com.algorithm.chapter_1.section_1;

import java.io.IOException;
import java.util.Scanner;

public class Euclid {

	public static long gcd(long p,long q) {
		if(q == 0) return p;
		long r = p % q;
		return gcd(q,r);
	}
	
	public static long gcd1(long p,long q) {
		
		System.out.println("" + p + ":" + q);
		
		if(q == 0) return p;
		long r = p % q;
		return gcd(q,r);
	}
	
	public static void main(String[] args) throws IOException {

		byte[] b = new byte[2];
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		int p = in.nextInt();
		
		System.out.println(gcd1(q,p));
		
	}

}
