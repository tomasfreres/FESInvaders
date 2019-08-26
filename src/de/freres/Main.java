package de.freres;

import javax.swing.*;
import javax.swing.JFrame;
import java.util.concurrent.TimeUnit;

public class Main extends JFrame{

    public KeyEventClass keyManager;

    public static void main(String[] args) throws InterruptedException {
        try {
            Controller controller = new Controller();
            controller.startThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
