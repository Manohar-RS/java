package java_practice;

class MyThread1 extends Thread {
    public MyThread1(String name, int priority) {
        super(name); // Set thread name
        setPriority(priority); // Set thread priority
    }

    @Override
    public void run() {
        System.out.println("Thread Name: " + getName());
        System.out.println("Thread Priority: " + getPriority());
    }
}

public class slip15_1 {
    public static void main(String[] args) {
        // Create a thread with name and priority
        MyThread1 t1 = new MyThread1("HighPriorityThread", Thread.MAX_PRIORITY); // Priority 10
        MyThread1 t2 = new MyThread1("LowPriorityThread", Thread.MIN_PRIORITY);  // Priority 1

        // Start the threads
        t1.start();
        t2.start();
    }
}
