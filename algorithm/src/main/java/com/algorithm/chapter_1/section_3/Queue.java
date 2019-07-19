package com.algorithm.chapter_1.section_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.algorithm.std.StdIn;
import com.algorithm.std.StdOut;

public class Queue<T> implements Iterable<T> {

	private Node<T> first;
	private Node<T> last;
	private int n;
	
	private class Node<T>{
		T item;
		Node<T> next;
	}
	
	public Queue(){
		first = null;
		last = null;
		n = 0;
	}
	
	public void enqueue(T item){
		Node<T> oldlast = last;
		last = new Node<T>();
		last.item = item;
		last.next = null;
		
		if(isEmpty()) first = last;
		else          oldlast.next = last;
		
		++n;
	}
	
	public T dequeue(){
		if(isEmpty()) throw new NoSuchElementException();
		Node<T> node = first;
		first = first.next;
		--n;
		if(isEmpty()) last = null;
		return node.item;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return n;
	}

	public Iterator<T> iterator() {
		return new QueueIterator(first);
	}
	
	private class QueueIterator implements Iterator<T>{

		private Node<T> current;
		
		public QueueIterator(Node<T> first){
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
		
		Queue<String> queue = new Queue<String>();
		
		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			if(!"-".equals(s)) queue.enqueue(s);
			else if(!queue.isEmpty()) 
				StdOut.println(queue.dequeue() + " dequeue");
		}
		
		StdOut.println(queue.size() + " left queue ");
		
	}


}
