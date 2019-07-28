package com.dll;
import java.util.LinkedList;


public class DLLTest {
    public static void main(String[] args) {
        DLL dll = new DLL();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(50);
        Node n4 = new Node(30);
        Node n5 = new Node(50);
        Node n6 = new Node(20);
        Node n7 = new Node(10);
        Node n8 = new Node(40);
        
        
        dll.push(n1);
        dll.push(n2);
        dll.push(n3);
        dll.push(n4);
        dll.push(n5);
        dll.push(n6);
        dll.push(n7);
 
        dll.printValuesBackwards();
        System.out.println("Removing last item: " + dll.pop());
        dll.insertAt(n8, 3);
        dll.printValuesForward();
        System.out.println("\n");
        dll.removeAt(3);
        dll.printValuesForward();
        System.out.println("\n");
        System.out.println("Contains value 30: " + dll.contains(30));
        System.out.println("\n");
        System.out.println("Number of nodes: " + dll.getCount());
        System.out.println("\n");
        System.out.println("This is a palindrome: " + dll.isPalindrome());

    }
}
