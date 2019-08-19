package de.freres;

import java.awt.*;


public class Player extends Token {
    private String name;
    private int score;

    public Player(String name, int posx, int posy){
        super(posx, posy);
        this.name = name;
        livePoints = 3;
    }

    @Override
    public void draw(Graphics g){
        g2d = (Graphics2D) g;
        Stroke stroke1 = new BasicStroke(2f);

        g2d.setColor(Color.BLUE);
        g2d.setStroke(stroke1);

        g2d.drawRect(posx, posy, 10, 10);
    }

    public void move(String move){
        if (move =="up"){
            super.getY();
            posy = posy + 10;
            super.setY(posy);
            draw(g);
        }
        if (move =="down"){
            super.getY();
            posy = posy + 10;
            super.setY(posy);
            draw(g);
        }
        if (move =="left"){
            super.getX();
            posx = posx - 10;
            super.setX(posx);
            draw(g);
        }
        if (move =="right"){
            super.getX();
            posx = posx + 10;
            super.setX(posx);
            draw(g);
        }
        System.out.println(move);
    }

}