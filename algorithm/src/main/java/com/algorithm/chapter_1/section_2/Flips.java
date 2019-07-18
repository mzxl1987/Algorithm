package com.algorithm.chapter_1.section_2;

import com.algorithm.std.StdIn;
import com.algorithm.std.StdOut;
import com.algorithm.std.StdRandom;

public class Flips {

	public static void main(String[] args) {
		
			int T = StdIn.readInt();
			Counter head = new Counter("head");
			Counter tail = new Counter("tail");
			for(int t = 0; t < T; t++){
				
				if(StdRandom.bernoulli(0.5)) head.increment();
				else                         tail.increment();
				
			}
			
			StdOut.println("delta : " + Math.abs(head.tally() - tail.tally()));
	}

}
