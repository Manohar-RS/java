package java_practice;

class MyThread4 extends Thread {
    public void run() {
        // Display the name of the currently executing thread
        System.out.println("Currently Executing Thread: " + Thread.currentThread().getName());
    }
}

public class slip28_2 {
    public static void main(String[] args) {
        // Creating multiple threads
        MyThread4 t1 = new MyThread4();
        MyThread4 t2 = new MyThread4();
        MyThread4 t3 = new MyThread4();

        // Naming threads
        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");

        // Starting threads
        t1.start();
        t2.start();
        t3.start();
    }
}
