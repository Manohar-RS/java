package java_practice;

import java.util.Scanner;

class VowelPrinter implements Runnable {
    private String input;

    // Constructor
    public VowelPrinter(String input) {
        this.input = input;
    }

    @Override
    public void run() {
        System.out.println("\nVowels will be displayed every 3 seconds:");
        for (char ch : input.toCharArray()) {
            if ("AEIOUaeiou".indexOf(ch) != -1) { // Check if the character is a vowel
                System.out.println(ch);
                try {
                    Thread.sleep(3000); // Pause for 3 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class slip23_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept a string from the user
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        // Create and start the thread
        Thread thread = new Thread(new VowelPrinter(userInput));
        thread.start();
        
        scanner.close();
    }
}

