package java_practice;

import java.util.Random;

class MyThread extends Thread {
    private String threadName;
    
    // Constructor to set the thread name
    public MyThread(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        try {
            // Generate random sleep time between 0 to 4999 ms
            Random rand = new Random();
            int sleepTime = rand.nextInt(5000); 

            System.out.println(threadName + " is created and running...");
            System.out.println(threadName + " is sleeping for " + sleepTime + " milliseconds");

            // Thread goes to sleep
            Thread.sleep(sleepTime);

            System.out.println(threadName + " has finished execution.");
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted.");
        }
    }
}

public class skip13_2 {
    public static void main(String[] args) {
        // Creating multiple threads with hardcoded names
        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");
        MyThread t3 = new MyThread("Thread-3");

        // Starting the threads (Moves from NEW to RUNNABLE to RUNNING state)
        t1.start();
        t2.start();
        t3.start();

        // Threads will automatically enter DEAD state after execution
    }
}

