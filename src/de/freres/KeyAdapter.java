package de.freres;

import java.awt.event.KeyEvent;

public class KeyAdapter extends java.awt.event.KeyAdapter {


        @Override
        public void keyPressed(KeyEvent e) {

            int keycode = e.getKeyCode();

            switch (keycode) {

            case KeyEvent.VK_LEFT:
                //TODO Move 1 to left on x-coordinate           methodMove (object of player, current x-coordinate -1);
                break;

            case KeyEvent.VK_RIGHT:
                //TODO Move 1 to left on x-coordinate;          methodMove (object of player, current x-coordinate +1);
                break;

            case KeyEvent.VK_UP:
                //TODO Implement Shoot method;
                break;

            case KeyEvent.VK_SPACE:
                //TODO Implement Shoot method;
                break;


        }



    }


}
