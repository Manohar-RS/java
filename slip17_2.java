package java_practice;

class NumberPrinter implements Runnable {
   // @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(i); // Print numbers to console
            try {
                Thread.sleep(200); // Pause for 200 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class slip17_2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new NumberPrinter()); // Create thread
        thread.start(); // Start thread
    }
}
