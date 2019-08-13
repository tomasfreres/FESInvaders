package de.freres;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Gamefield game = new Gamefield();

        JFrame field = new JFrame("FESInvaders");

        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        field.setSize(450, 300);

        field.add(game);

        field.setVisible(true);
    }
}
