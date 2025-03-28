package java_practice;

import java.util.Random;

class NumberGenerator extends Thread {
    public int number;

    public void run() {
        Random rand = new Random();
        while (true) {
            number = rand.nextInt(100) ; // Generate a random number (1-100)
            System.out.println("\nGenerated Number: " + number);

            if (number % 2 == 0) {
                new SquareThread(number).start();
            } else {
                new CubeThread(number).start();
            }

            try {
                Thread.sleep(1000); // Wait for 1 second before generating next number
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class SquareThread extends Thread {
    private int number;

    SquareThread(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Square of " + number + " = " + (number * number));
    }
}

class CubeThread extends Thread {
    private int number;

    CubeThread(int number) {
        this.number = number;
    }

    public void run() {
        System.out.println("Cube of " + number + " = " + (number * number * number));
    }
}

public class slip7_1 {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        generator.start(); // Start number generation
    }
}

