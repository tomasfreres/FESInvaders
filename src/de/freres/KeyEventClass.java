package de.freres;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import java.awt.event.KeyEvent.*;

import static java.awt.event.KeyEvent.*;

public class KeyEventClass implements KeyListener {
    private Controller conrtoller;

    public KeyEventClass(Controller conrtoller) {
        this.conrtoller = conrtoller;
    }

    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped: ");
        if (e.getKeyChar() == KeyEvent.CHAR_UNDEFINED) {
            System.out.println("Kein Unicode-Character gedr\u00FCckt!");
        } else {
            System.out.println(e.getKeyChar() + " gedr\u00FCckt!");
        }
        System.out.println("---");
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

    @Override
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()) {
                case VK_LEFT:
                    this.conrtoller.movePlayer("left");
                    break;
                case VK_RIGHT:
                    this.conrtoller.movePlayer("right");
                    break;

                case VK_UP:
                    this.conrtoller.movePlayer("up");
                    break;
                case VK_DOWN:
                    this.conrtoller.movePlayer("down");
                    break;
            }
    }
}

