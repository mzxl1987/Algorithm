package com.algorithm.chapter_1.section_2;

import com.algorithm.std.StdDraw;
import com.algorithm.std.StdIn;
import com.algorithm.std.StdOut;
import com.algorithm.std.StdRandom;

/******************************************************************************
 *  Compilation:  javac VisualAccumulator.java
 *  Execution:  none
 *  Dependencies: StdDraw.java
 *
 *  Visual accumulator mutable data type.
 *
 ******************************************************************************/


public class VisualAccumulator {
    private double total;
    private int n;

    public VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(0.005);
    }

    public void addDataValue(double value) {
        n++;
        total += value;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(n, value);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(n, mean());
    }

    public double mean() {
        return total / n;
    }


    public String toString() {
        return "n = " + n + ", mean = " + mean();
    }
    
    public static void main(String[] args) {
		int T = StdIn.readInt();
		VisualAccumulator va = new VisualAccumulator(T, 1.0);
		for (int i = 0; i < T; i++) {
			va.addDataValue(StdRandom.random());
		}
		StdOut.println(va);
	}
    
}