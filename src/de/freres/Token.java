package de.freres;

import javax.swing.*;
import java.awt.*;

public abstract class Token {

    protected int livePoints;
    protected int shootFrequency;
    protected int damage;
    protected int posx;
    protected int posy;
    protected Graphics2D g2d;

    public Token(int posx, int posy){
        this.posx = posx;
        this.posy = posy;
    }

    public void shoot(String shooter, Graphics g){
        //Position von Raumschiff bzw. Alien bestimmen

        posx = getX();
        posy = getY();

        //Von dort ausgehend ein Objekt kreiieren

        g2d = (Graphics2D) g;
        Stroke stroke1 = new BasicStroke(2f);

        g2d.setColor(Color.WHITE);
        g2d.setStroke(stroke1);

        g2d.fillRect(posx, posy, 10, 10);

        //Dieses in Richtung des Gegners senden
        if(shooter=="player") {
            for (int i = 0; i < 300; i++) {
                posx++;
                posy++;
            }
        }
        else {
            for (int i = 0; i < 300; i++) {
                posx--;
                posy--;
            }
        }

    }

    public void getDamage(int damage){
        this.damage -= damage;
    }

    public void draw(Graphics g){

    }

    public int getX(){
        return posx;
    }
    public int getY(){
        return posy;
    }
    public void setX(int x){
        posx = x;
    }
    public void setY(int y){
        posy = y;
    }

}
