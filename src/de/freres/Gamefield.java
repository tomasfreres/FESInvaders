package de.freres;

import javax.swing.*;
import java.awt.*;

public class Gamefield extends Canvas {

    public Gamefield(){

    }

    public void paint(Graphics g){
        Alien a = new Alien(30, 50);
        Alien b = new Alien(50, 50);
        Alien c = new Alien(70, 50);
        Alien d = new Alien(90, 50);
        Alien e = new Alien(110, 50);
        Alien f = new Alien(30, 70);
        Alien ge = new Alien(50, 70);

        setBackground(Color.BLACK);
        a.draw(g);
        b.draw(g);
        c.draw(g);
        d.draw(g);
        e.draw(g);
        f.draw(g);
        ge.draw(g);

        c.destroy();
    }

}
