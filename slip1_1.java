package java_practice;
//import java.io.*;


public class slip1_1 extends Thread {
	public void run() {
	try {
		for(char c='A'; c<='Z';c++)
		{
			System.out.println("Generated Character is :"+c);
			Thread.sleep(2000);
		}
	}
	catch(InterruptedException e) {
	        System.out.println("Error "+e);
	}
	}


	public static void main(String[] args) {
		slip1_1 t1=new slip1_1();
		t1.start();

	}

}
