package de.freres;

import javax.swing.*;
import javax.swing.JFrame;

public class Main extends JFrame{

    public static void main(String[] args) {
        Gamefield game = new Gamefield();

        JFrame field = new JFrame("FESInvaders");

        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        field.setSize(450, 600);

        field.add(game);

        field.setVisible(true);
    }
}
