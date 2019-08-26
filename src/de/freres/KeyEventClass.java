package de.freres;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyEventClass implements KeyListener {
    private boolean[] keys;
    public boolean up, down, left, right;

    public KeyEventClass(){
        System.out.println("Constructor");
        keys = new boolean[256];
    }

    public void update(Player player){
        up = keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_D];
        player.move(left,right, up, down);

    }
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }
    @Override
    public void keyReleased(KeyEvent e) {
            keys[e.getKeyCode()] = false ;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");

    }
    public void reset(){
        keys = new boolean[256];
    }
}
