package de.freres;

import java.awt.*;

public class Alien extends Token {
    private int scorePoints;

    public Alien(int posx, int posy){
        super(posx, posy);
        scorePoints = 10;
    }

    @Override
    public void draw(Graphics g){
        g2d = (Graphics2D) g;
        Stroke stroke1 = new BasicStroke(2f);

        g2d.setColor(Color.WHITE);
        g2d.setStroke(stroke1);

        g2d.drawRect(posx, posy, 10, 10);
    }

    public void destroy(){
        Stroke stroke1 = new BasicStroke(2f);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(stroke1);

        g2d.drawRect(posx, posy, 10, 10);
    }
    public void shoot(){

    }


}
