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
        //System.out.println("" + left + "" + right + "" + up + "" + down);
        player.move(left,right, up, down);

    }
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println("keyPressed " + e.getKeyCode() + " | " + KeyEvent.VK_W + " is " + keys[KeyEvent.VK_W]);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (up = true){
            keys[e.getKeyCode()] = true;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped");

    }
    public void reset(){
        keys = new boolean[256];
    }
}
