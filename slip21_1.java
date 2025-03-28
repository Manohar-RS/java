package java_practice;

import java.util.*;

public class slip21_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> subjects = new LinkedList<>();

        // Accepting number of subjects
        System.out.print("Enter the number of subjects: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Accepting subject names
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter subject " + i + ": ");
            subjects.add(scanner.nextLine());
        }

        // Displaying subjects using Iterator
        System.out.println("\nSubjects List:");
        Iterator<String> iterator = subjects.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        scanner.close();
    }
}
