package de.freres;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Token is an abstract class that defines the main objects on the game field
 */
public abstract class Token {


    protected int lifePoints;
    protected int shootFrequency;
    protected int damage;
    protected int posx;
    protected int posy;
    protected Graphics2D g2d;

    /**
     *
     * @param posx Position on the X-axis
     * @param posy Position on the Y-axis
     */
    public Token(int posx, int posy){
        this.posx = posx;
        this.posy = posy;
    }

    public void getDamage(int damage){
        this.damage -= damage;
    }

    /**
     * Draws Token and descendants on the given graphic context g
     * @param g
     */
    public void draw(Graphics g){
        g2d = (Graphics2D) g;
        g2d.drawImage(this.getImage(), posx, posy, 35, 35, null);
    }

    // implements Hitbox from Alien and Player

    /**
     * Tests if the given shot is inside bounds of hitbox
     * @param shot
     * @return
     */
    public boolean hitbox (Shot shot){
        if(shot.getX() >= posx && shot.getX() < posx + 35 && shot.getY() == posy){
            lifePoints--;
            System.out.println("Treffer");
            return true;    }
        else {
           return false;
        }
    }

    public abstract BufferedImage getImage();

    public int getX(){

        return posx;
    }
    public int getY(){
        return posy;
    }
    public int getLifePoints(){
        return this.lifePoints;
    }
    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
    public void setX(int x){
        posx = x;
    }
    public void setY(int y){
        posy = y;
    }

    /**
     * Moves Token or descendant into given direction
     * @param dir
     */
    public void move(String dir){
        if(dir == "right"){
            posx = posx + 25;
        }
        if(dir == "left"){
            posx = posx - 25;
        }
    }


    public void tinyMove(String dir){
        if(dir == "right"){
            posx = posx + 1;
        }
        if(dir == "left"){
            posx = posx - 1;
        }
    }

}
