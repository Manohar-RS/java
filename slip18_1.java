package java_practice;

class MyThread2 extends Thread {
    public MyThread2(String name, int priority) {
        setName(name);      // Set thread name
        setPriority(priority); // Set thread priority
    }

    @Override
    public void run() {
        System.out.println("Thread Name: " + getName());
        System.out.println("Thread Priority: " + getPriority());
    }
}

public class slip18_1 {
    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2("WorkerThread", Thread.MAX_PRIORITY); // Priority 10
        MyThread2 t2 = new MyThread2("HelperThread", Thread.MIN_PRIORITY); // Priority 1

        t1.start(); // Start first thread
        t2.start(); // Start second thread
    }
}

