package com.algorithm.chapter_1.section_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.algorithm.std.StdIn;
import com.algorithm.std.StdOut;

public class Stack<T> implements Iterable<T> {

	private int n;
	
	private Node<T> first;
	
	private class Node<T>{
		T item;
		Node<T> next;
	}
	
	public Stack(){
		first = null;
		n = 0;
	}
	
	public void push(T item){
		Node<T> oldfirst = first;
		first = new Node<T>();
		first.item = item;
		first.next = oldfirst;
		++n;
	}
	
	public T pop(){
		if(isEmpty()) throw new NoSuchElementException();
		T item = first.item;
		first = first.next;
		--n;
		return item;
	}
	
	public T peek(){
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		return first.item;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return n;
	}

	public Iterator<T> iterator() {
		return new StackIterator(first);
	}

	private class StackIterator implements Iterator<T>{

		private Node<T> current;
		
		public StackIterator(Node<T> first){
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
		Stack<String> stack = new Stack<String>();
		while(!StdIn.isEmpty()){
			String s = StdIn.readString();
			if(!"-".equals(s)) stack.push(s);
			else if(!stack.isEmpty())
				StdOut.println(stack.pop() + " pop from stack ");
		}
		StdOut.println(stack.size() + " left on stack");

	}

}
