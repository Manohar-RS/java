package java_practice;

import java.util.Scanner;
import java.util.TreeSet;

public class slip17_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Integer> numbers = new TreeSet<>(); // TreeSet for sorted unique values

        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt()); // TreeSet will remove duplicates automatically
        }

        // Display the sorted unique numbers
        System.out.println("Sorted Unique Integers: " + numbers);

        scanner.close();
    }
}

