package java_practice;

//Define a thread class that prints a given text 'n' times
class PrintThread extends Thread {
 private String text;
 private int count;

 // Constructor to initialize text and number of times to print
 public PrintThread(String text, int count) {
     this.text = text;
     this.count = count;
 }

 // Run method that prints the text 'count' times
 public void run() {
	 try{
     for (int i = 1; i <= count; i++) {
         System.out.println(text + " - " + i);
         Thread.sleep(1000);
     }
	 }
	 catch(InterruptedException e) {
	        System.out.println("Error "+e);
	}
	 }
 }


//Main class to start three threads
public class slip8_1 {
 public static void main(String[] args) {
     // Create three threads with different text and count
     PrintThread thread1 = new PrintThread("COVID19", 10);
     PrintThread thread2 = new PrintThread("LOCKDOWN2020", 20);
     PrintThread thread3 = new PrintThread("VACCINATED2021", 30);

     // Start the threads
     thread1.start();
     thread2.start();
     thread3.start();
 }
}

