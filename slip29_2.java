package java_practice;

import java.util.LinkedList;

public class slip29_2 {
    public static void main(String[] args) {
        // Create a LinkedList of Integer objects
        LinkedList<Integer> numbers = new LinkedList<>();

        // Adding elements to the LinkedList
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        System.out.println("Original LinkedList: " + numbers);

        // i. Add element at the first position
        numbers.addFirst(5);
        System.out.println("After adding 5 at first position: " + numbers);

        // ii. Delete last element
        numbers.removeLast();
        System.out.println("After deleting last element: " + numbers);

        // iii. Display the size of the LinkedList
        System.out.println("Size of LinkedList: " + numbers.size());
    }
}
