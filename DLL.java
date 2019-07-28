package com.dll;
import java.util.LinkedList;

public class DLL {
    public Node head;
    public Node tail;
    
    public DLL() {
        this.head = null;
        this.tail = null;
    }
    
    // the push method will add a new node to the end of the list
	public void push(Node newNode) {
	// if there is no head in the list, aka, an empty list, we set the newNode to be the head and tail of the list
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }
	
	public void pushFront(Node newNode) {
        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        Node firstNode = this.head;
        firstNode.previous = newNode;
        newNode.next = firstNode;
        this.head = newNode;
    }
    
	public void printValuesForward() {
        // find the first node, aka head.
        Node current = this.head;
        
        // while the current node exists...
        while(current != null) {
            // print it's value
            System.out.println(current.value);
            // and move on to it's next node.
            current = current.next;
        }
    }
	
	// Prints nodes backwards
	public void printValuesBackwards() { 
        Node current = this.tail;
        while(current != null) {
            System.out.println(current.value);
            current = current.previous;
        }
    }
	
	// Returns LinkedList<Integer>
	public LinkedList<Integer> returnList() {
		Node current = this.head;
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		while(current != null) {
			list.add(current.value);
			current = current.next;
		}
		return list;
	}

	// Remove the last node
	public LinkedList<Integer> pop() {
		LinkedList<Integer> list = returnList();
		Node current = this.tail;
		list.remove(list.size() - 1);
		current = current.previous;
		return list;
	}
	
	// Insert at index
	public void insertAt(Node newNode, int index) {
		if (index == 0) {
			newNode.next = this.head;
			this.head = newNode;
		}
		else {
			Node current = this.head;
			int i = 0;
			while (i < index - 1 && current.next!=null) {
				current = current.next;
				i++;
			}
			newNode.next = current.next;
			current.next = newNode;
			
		}
	}
	
	// Remove at index
	public void removeAt(int index) {
		if (index == 0) {
			Node current = this.head;
			current.next = current.next.next;
			current = current.next;
		}
		else {
			Node current = this.head;
			int i = 0;
			while (i < index - 1 && current.next!=null) {
				current = current.next;
				i++;
			}
			current.next = current.next.next;
			current = current.next;
		}
		
		
	}
	
	// Check if the list contains a specified value
	public boolean contains(Integer value) {
		LinkedList<Integer> list = returnList();
		if (list.contains(value)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// Check if the List is a palindrome or not
	public boolean isPalindrome() {
		LinkedList<Integer> list = returnList();
		Node current = this.tail;
		int bool = 1;
		for (int i = 0; i < (list.size()/2); i++) {
			if (list.get(i) == current.value) {
				bool = 1;
				current = current.previous;
			}
			else {
				bool = 0;
				break;
			}	
		}
		if (bool == 1) {
			return true;
		}
		else {
			return false;
		}
	
	}
	
	
	public int getCountRec(Node node) 
    { 
        // Base case 
        if (node == null) 
            return 0; 
  
        // Count is this node plus rest of the list 
        return 1 + getCountRec(node.next); 
    } 
	
	// returns number of nodes in list
    public int getCount() 
    { 
        return getCountRec(head); 
    } 
    
    
	
	
}
