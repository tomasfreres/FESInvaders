package de.freres;

import javax.swing.*;
import java.awt.*;

public class Gamefield extends Canvas {

    private Graphics gr;

    public Gamefield(){

    }

    public void paint(Graphics g){
        this.gr = g;
        Alien a = new Alien(30, 50);
        Alien b = new Alien(50, 50);
        Alien c = new Alien(70, 50);
        Alien d = new Alien(90, 50);
        Alien e = new Alien(110, 50);
        Alien f = new Alien(30, 70);
        Alien ge = new Alien(50, 70);


        Shot sa = new Shot(140,50, "up");

        setBackground(Color.BLACK);
        a.draw(gr);
        b.draw(gr);
        c.draw(gr);
        d.draw(g);
        e.draw(g);
        f.draw(g);
        ge.draw(g);
        sa.draw(g);

        g.drawString("Highscore: ", 130, 50);

        c.destroy();
    }

    public Graphics getGraphicsContext(){
        return gr;
    }

}
