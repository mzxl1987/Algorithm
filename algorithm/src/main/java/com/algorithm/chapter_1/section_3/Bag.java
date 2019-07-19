package com.algorithm.chapter_1.section_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.algorithm.std.StdIn;
import com.algorithm.std.StdOut;

public class Bag<T> implements Iterable<T> {

	private int n;
	
	private Node<T> first;
	
	private class Node<T>{
		T item;
		Node<T> next;
	}
	
	public Bag(){
		first = null;
		n = 0;
	}
	
	public void add(T item){
		Node<T> oldfirst = first;
		first = new Node<T>();
		first.next = oldfirst;
		first.item = item;
		n++;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return n;
	}
	
	
	
	public Iterator<T> iterator() {
		return new BagIterator(first);
	}
	
	private class BagIterator implements Iterator<T>{

		private Node<T> current;
		
		public BagIterator(Node<T> first){
			this.current = first;
		}
		
		public boolean hasNext() {
			return current != null;
		}

		public T next() {
			if(!hasNext()) throw new NoSuchElementException();
			T item = current.item;
			current = current.next;
			return item;
		}
		
	} 
	
	
	public static void main(String[] args) {
		
		Bag<String> bag = new Bag<String>();
		while(!StdIn.isEmpty()){
			bag.add(StdIn.readString());
		}
		
		StdOut.println("size : " + bag.size());

		for (String item : bag) {
			StdOut.println(item);
		}
		
	}

	

}
