package java_practice;

import javax.swing.*;
import java.awt.*;

public class slip20_2 extends JFrame implements Runnable {
    private ImageIcon image;  // Image to display
    private JLabel label;     // JLabel to hold image
    private boolean visible = true; // Image visibility flag

    // Constructor
    public slip20_2() {
        setTitle("Blinking Image");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Load Image
        image = new ImageIcon("SAP_8602.JPG"); // Change "image.jpg" to your image path
        label = new JLabel(image);
        add(label);

        // Start Thread for Blinking
        Thread thread = new Thread(this);
        thread.start();

        setVisible(true);
    }

    // Run method to blink image
    @Override
    public void run() {
        while (true) {  // Infinite loop for continuous blinking
            try {
                Thread.sleep(1000); // Wait 1 second
                visible = !visible; // Toggle visibility
                label.setVisible(visible); // Show/Hide Image
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        new slip20_2();
    }
}

