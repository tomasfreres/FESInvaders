package de.freres;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyEventClass implements KeyListener {
    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped: ");
        if (e.getKeyChar() == KeyEvent.CHAR_UNDEFINED) {
            System.out.println("Kein Unicode-Character gedr\u00FCckt!");
        } else {
            System.out.println(e.getKeyChar() + " gedr\u00FCckt!");
        }
        System.out.println("---");
    }

    @Override
    public void keyPressed(KeyEvent e){
    int myKey = e.getKeyCode();
        if (myKey == KeyEvent.VK_RIGHT) {

    }
        if (myKey == KeyEvent.VK_LEFT) {

        }
}

    public void keyReleased(KeyEvent e) {
        System.out.println("KeyReleased: ");
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("Programmabbruch!");
            System.exit(0);
        }
        System.out.println("Taste: " + e.getKeyChar() + ", Code: " + e.getKeyCode());
        System.out.println("---");
    }
}

