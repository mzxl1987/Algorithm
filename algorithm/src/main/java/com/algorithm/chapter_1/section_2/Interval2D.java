package com.algorithm.chapter_1.section_2;

import java.awt.Color;

import com.algorithm.std.StdDraw;
import com.algorithm.std.StdIn;
import com.algorithm.std.StdOut;
import com.algorithm.std.StdRandom;

/******************************************************************************
 *  Compilation:  javac Interval2D.java
 *  Execution:    java Interval2D
 *  Dependencies: StdOut.java Interval1D.java StdDraw.java
 *  
 *  2-dimensional interval data type.
 *
 ******************************************************************************/

/**
 *  The {@code Interval2D} class represents a closed two-dimensional interval,
 *  which represents all points (x, y) with both {@code xmin <= x <= xmax} and
 *  {@code ymin <= y <= ymax}.
 *  Two-dimensional intervals are immutable: their values cannot be changed
 *  after they are created.
 *  The class {@code Interval2D} includes methods for checking whether
 *  a two-dimensional interval contains a point and determining whether
 *  two two-dimensional intervals intersect.
 *  <p>
 *  For additional documentation, 
 *  see <a href="https://algs4.cs.princeton.edu/12oop">Section 1.2</a> of 
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne. 
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Interval2D {
    private final Interval1D x;
    private final Interval1D y;

    /**
     * Initializes a two-dimensional interval.
     * @param x the one-dimensional interval of x-coordinates
     * @param y the one-dimensional interval of y-coordinates
     */
    public Interval2D(Interval1D x, Interval1D y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Does this two-dimensional interval intersect that two-dimensional interval?
     * @param that the other two-dimensional interval
     * @return true if this two-dimensional interval intersects
     *    that two-dimensional interval; false otherwise
     */
    public boolean intersects(Interval2D that) {
        if (!this.x.intersects(that.x)) return false;
        if (!this.y.intersects(that.y)) return false;
        return true;
    }

    /**
     * Does this two-dimensional interval contain the point p?
     * @param p the two-dimensional point
     * @return true if this two-dimensional interval contains the point p; false otherwise
     */
    public boolean contains(Point2D p) {
        return x.contains(p.x())  && y.contains(p.y());
    }

    /**
     * Returns the area of this two-dimensional interval.
     * @return the area of this two-dimensional interval
     */
    public double area() {
        return x.length() * y.length();
    }
        
    /**
     * Returns a string representation of this two-dimensional interval.
     * @return a string representation of this two-dimensional interval
     *    in the form [xmin, xmax] x [ymin, ymax]
     */
    public String toString() {
        return x + " x " + y;
    }

    /**
     * Does this interval equal the other interval?
     * @param other the other interval
     * @return true if this interval equals the other interval; false otherwise
     */
    public boolean equals(Object other) {
        if (other == this) return true;
        if (other == null) return false;
        if (other.getClass() != this.getClass()) return false;
        Interval2D that = (Interval2D) other;
        return this.x.equals(that.x) && this.y.equals(that.y);
    }

 
    /**
     * Returns an integer hash code for this interval.  
     * @return an integer hash code for this interval 
     */
    public int hashCode() {
        int hash1 = x.hashCode();
        int hash2 = y.hashCode();
        return 31*hash1 + hash2;
    }

    /**
     * Draws this two-dimensional interval to standard draw.
     */
    public void draw() {
        double xc = (x.min() + x.max()) / 2.0;
        double yc = (y.min() + y.max()) / 2.0;
        StdDraw.rectangle(xc, yc, x.length() / 2.0, y.length() / 2.0);
    }

    /**
     * Unit tests the {@code Interval2D} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        testCase2();
    }
    
    private static void testCase1(){
    	double xmin = StdIn.readDouble();
        double xmax = StdIn.readDouble();
        double ymin = StdIn.readDouble();
        double ymax = StdIn.readDouble();
        int trials = StdIn.readInt();

        Interval1D xInterval = new Interval1D(xmin, xmax);
        Interval1D yInterval = new Interval1D(ymin, ymax);
        Interval2D box = new Interval2D(xInterval, yInterval);
        box.draw();

        Counter counter = new Counter("hits");
        for (int t = 0; t < trials; t++) {
            double x = StdRandom.uniform(0.0, 1.0);
            double y = StdRandom.uniform(0.0, 1.0);
            Point2D point = new Point2D(x, y);

            if (box.contains(point)) counter.increment();
            else                     point.draw();
        }

        StdOut.println(counter);
        StdOut.printf("box area = %.2f\n", box.area());
    }
    

    private static void testCase2(){
    	double min = StdIn.readDouble();
        double max = StdIn.readDouble();
        int trials = StdIn.readInt();

        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenRadius(0.005);
        StdDraw.enableDoubleBuffering();

        StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.BLUE);

        Interval2D[] arr = new Interval2D[trials];
        for (int i = 0; i < trials; i++) {
            double xmin = StdRandom.uniform(min, max);
            double xmax = StdRandom.uniform(xmin, max);
            double ymin = StdRandom.uniform(min, max);
            double ymax = StdRandom.uniform(ymin, max);
            
            Interval1D xInterval = new Interval1D(xmin, xmax);
            Interval1D yInterval = new Interval1D(ymin, ymax);
            arr[i] = new Interval2D(xInterval, yInterval);
            arr[i].draw();

            // TODO
	        // TODO
            
            StdDraw.show();
            
        }
        
    }
}