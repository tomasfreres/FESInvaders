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

    public void shoot(){

    }

    public void getDamage(int damage){
        this.damage -= damage;
    }

    public void draw(Graphics g){

    }

}
