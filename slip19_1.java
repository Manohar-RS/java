package java_practice;

import java.util.LinkedList;
import java.util.Scanner;

public class slip19_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> numbers = new LinkedList<>();

        // Accepting 'N' integers from the user
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());  // Add input to LinkedList
        }

        // Display only negative numbers
        System.out.println("\nNegative numbers in the list:");
        for (int num : numbers) {
            if (num < 0) {
                System.out.print(num + " ");
            }
        }

        scanner.close();
    }
}
