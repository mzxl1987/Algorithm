package com.algorithm.chapter_1.section_2;

import com.algorithm.std.StdIn;
import com.algorithm.std.StdRandom;

public class Rolls {

	public static void main(String[] args) {

		while(true){
			int T = StdIn.readInt();
			final int SIDES = 6;
			Counter[] rolls = new Counter[SIDES]; 
			
			for(int i = 0; i < SIDES; i++){
				rolls[i] = new Counter(i + 1 + "'s");
			}
			
			int rand;
			while(T-- > 0){
				rand = StdRandom.uniform(0, SIDES);
				rolls[rand].increment();
			}
			
			for (Counter counter : rolls) {
				System.out.println(counter);
			}
			
		}
	}

}
