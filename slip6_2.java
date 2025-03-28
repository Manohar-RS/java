package java_practice;
import java.util.*;

class TrafficSignal extends Thread {
    public void run() {
        while (true) { // Infinite loop
            System.out.println("🚦 Traffic Light: RED");
            try { Thread.sleep(5000); } catch (InterruptedException e) {}

            System.out.println("🚦 Traffic Light: YELLOW");
            try { Thread.sleep(5000); } catch (InterruptedException e) {}

            System.out.println("🚦 Traffic Light: GREEN");
            try { Thread.sleep(5000); } catch (InterruptedException e) {}
        }
    }
}

public class slip6_2 {
    public static void main(String[] args) {
        TrafficSignal trafficSignal = new TrafficSignal();
        trafficSignal.start(); // Start the traffic light simulation
    }
}
