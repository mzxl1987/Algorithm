package com.algorithm.chapter_1.section_2;

public class Counter implements Comparable<Counter>{

	private String id;
	private int value;
	
	public Counter(String id){
		this.id = id;
		this.value = 0;
	}
	
	public void increment(){
		value++;
	}
	
	public int tally(){
		return value;
	}
	
	@Override
	public String toString() {
		return "id : " + id + ", value : " + value;
	}

	public int compareTo(Counter o) {
		if(this.value > o.value) return 1;
		else if(this.value < o.value) return -1;
		else return 0;
	}
	
}
