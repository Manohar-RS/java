package java_practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class slip23_2 {
    public static void main(String[] args) {
        // Check if at least one student name is provided
        if (args.length == 0) {
            System.out.println("Please enter student names as command-line arguments.");
            return;
        }

        // Create an ArrayList to store student names
        ArrayList<String> students = new ArrayList<>();

        // Store names into the ArrayList
        for (String name : args) {
            students.add(name);
        }

        // Display student names using Iterator (Forward direction)
        System.out.println("\nStudent Names (Forward Order):");
        Iterator<String> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Display student names using ListIterator (Backward direction)
        System.out.println("\nStudent Names (Reverse Order):");
        ListIterator<String> listIterator = students.listIterator(students.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}

