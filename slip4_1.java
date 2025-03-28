package java_practice;
import java.util.*;
import java.util.Hashtable;
import java.util.Enumeration;

public class slip4_1 {
    public static void main(String[] args) {
        // Creating a Hashtable to store student names and mobile numbers
        Hashtable<String, String> studentTable = new Hashtable<>();

        // Adding some predefined student details
        studentTable.put("Alice", "9876543210");
        studentTable.put("Bob", "8765432109");
        studentTable.put("Charlie", "7654321098");
        studentTable.put("David", "6543210987");

        // Using Enumeration to display student details
        System.out.println("Student Details:");
        Enumeration<String> names = studentTable.keys();
        while (names.hasMoreElements()) {
            String studentName = names.nextElement();
            System.out.println(studentName + " - " + studentTable.get(studentName));
         
        }
    }

}