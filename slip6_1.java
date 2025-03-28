package java_practice;
import java.util.*;

public class slip6_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TreeSet to store unique elements in sorted order
        TreeSet<Integer> numbers = new TreeSet<>();

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " unique numbers:");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (!numbers.add(num)) {
                System.out.println("Duplicate detected! Please enter a unique number.");
                i--; // Ask for input again
            }
        }

        // Convert TreeSet to List for binary search
        List<Integer> sortedList = new ArrayList<>(numbers);
        
        // Display sorted elements
        System.out.println("Sorted elements: " + sortedList);

        // Searching for an element
        System.out.print("Enter a number to search: ");
        int searchNum = scanner.nextInt();
        
        // Using binarySearch method from Collections framework
        int index = Collections.binarySearch(sortedList, searchNum);
        
        if (index >= 0) {
            System.out.println(searchNum + " found at position " + (index + 1));
        } else {
            System.out.println(searchNum + " not found.");
        }

        scanner.close();
    }
}
