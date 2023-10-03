package pecci;

import java.util.NoSuchElementException;

public class Stack {
	private Node head;
	private Node tail;
	
	private double mean = 0;
	
	public Stack() {
		head = null;
		tail = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	

	public void push (int n) {
		Node temp = new Node(n);
		
		if(head == null) {
			head = temp;
			tail = temp;
		} 
		
		else {
			tail.next = temp;
			tail = temp;
		}
				
	}
	public int pop() {
		if(isEmpty()) {
			throw new NoSuchElementException("Runtime Exception");
		} else if (head != null && head == tail) {
			int backItem = tail.n;
			head = null;
			tail = null;
			return backItem;
		} else {
			int value = tail.n;
			tail = tail.prev;
			tail.next = null;
			return value;
		}
	}
	
	public Node getTail() {
		return tail;
	}
	
	 public double mean() {
	    	int total = 0;
	    	int i = 0;
	    	Node current = head;
	    	while (current != null) {
	    		total += current.n;
	    		current = current.next;
	    		i++;
	    	}
	    	mean = total/i;
	    	return mean;
	    }
	    
	    public double stdDev() {
	    	double total = 0;
	    	int i = 0;
	    	Node current = head;
	    	while (current != null) {
	    		total += Math.pow(mean - current.n, 2);
	    		current = current.next;
	    		i++;
	    	}
	    	total = total / i;
	    	return Math.sqrt(total);
	    }
}
