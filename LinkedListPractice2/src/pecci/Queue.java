package pecci;

import java.util.NoSuchElementException;

public class Queue {
	
	private Node head;
	private Node tail;
	
	public Queue() {
		head = null;
		tail = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void enqueue (int n) {
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
	public int dequeue() {
		if(isEmpty()) {
			throw new NoSuchElementException("Runtime Exception");
		} else if (head == tail) {
			int frontItem = head.n;
			head = null;
			tail = null;
			return frontItem;
		} else {
			int frontItem = head.n;
			head = head.next;
			return frontItem;
		}
	}
	public Node getHead() {
		return head;
	}
	
}
