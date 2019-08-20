package de.freres;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Token {
    private String name;
    private int score;
    static protected BufferedImage image;
    static {
        try {
            image = ImageIO.read(Alien.class.getResource("/SpaceShip.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Player(String name, int posx, int posy){
        super(posx, posy);
        this.name = name;
        lifePoints = 3;
    }

    @Override
    public void draw(Graphics g){
        g2d = (Graphics2D) g;
        Stroke stroke1 = new BasicStroke(2f);

        g2d.setColor(Color.BLUE);
        g2d.setStroke(stroke1);

        g2d.drawRect(posx, posy, 10, 10);
    }

    @Override
    public BufferedImage getImage() {
        return Player.image;
    }

    public void move(){

    }

}