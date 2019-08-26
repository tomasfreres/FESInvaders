package de.freres;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyEventClass implements KeyListener {
    public int currentEvent;

    @Override
    public void keyTyped(KeyEvent e) {
        currentEvent = e.getKeyCode();
        System.out.println(currentEvent);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

