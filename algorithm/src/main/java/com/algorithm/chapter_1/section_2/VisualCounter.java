package com.algorithm.chapter_1.section_2;

import com.algorithm.std.StdDraw;
import com.algorithm.std.StdIn;
import com.algorithm.std.StdOut;

/**
 * 1.2.10
 * @author Administrator
 *
 */
public class VisualCounter {

	private int count;
	private int max;
	private int n;
	private int N;
	
	public VisualCounter(int N,int max){
		this.N = N;
		this.max = Math.abs(max);
	}
	
	public void increase(){
		if( N <= n  || Math.abs(count) >= max ) return;
		n++;
		count++;
	}
	
	public void decrease(){
		if( N <= n || Math.abs(count) >= max ) return;
		n++;
		count--;
	}
	
	public int getCount(){ return count; }
	
	public static void main(String[] args) {
		
		StdOut.printf(" N = ");
		int N = StdIn.readInt();
		StdOut.printf(" max = ");
		int max = StdIn.readInt();

		VisualCounter vc = new VisualCounter(N, max);
		
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenRadius(0.005);
        StdDraw.enableDoubleBuffering();

        StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.BLUE);
        
        while(true){
        	
        	char c = StdIn.readChar();
        	if('+' == c) vc.increase();
        	else if('-' == c) vc.decrease();
        	StdDraw.clear();
        	StdDraw.text(50, 50, "" + vc.getCount());
        	
        	StdDraw.show();
        }
		
	}

}
