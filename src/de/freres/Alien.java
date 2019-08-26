package de.freres;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

public class Alien extends Token {
    private int scorePoints;
    static protected BufferedImage image;
    static {
        try {
            image = ImageIO.read(Alien.class.getResource("/Alien.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Alien(int posx, int posy) {
        super(posx, posy);
        scorePoints = 10;
        lifePoints = 1;
    }

    @Override
    public BufferedImage getImage() {
        return Alien.image;
    }

    public void destroy(){
        Stroke stroke1 = new BasicStroke(2f);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(stroke1);

        g2d.drawRect(posx, posy, 10, 10);
    }

}
