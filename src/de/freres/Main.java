package de.freres;

import javax.swing.*;
import javax.swing.JFrame;

public class Main extends JFrame{

    public static void main(String[] args) {
        JFrame field = new JFrame("FESInvaders");

        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        field.setContentPane(new Gamefield());

        field.pack();

        field.setVisible(true);
    }
}
