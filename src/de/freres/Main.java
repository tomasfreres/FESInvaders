package de.freres;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame field = new JFrame("FESInvaders");

        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        field.setContentPane(new Gamefield());

        field.pack();

        field.setVisible(true);
    }
}
