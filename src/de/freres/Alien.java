package de.freres;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

/**
 * Alien class is a subclass of token
 */
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

    /**
     *
     * @param posx Position on the X-axis of the alien
     * @param posy Position on the Y-axis of the alien
     */
    public Alien(int posx, int posy) {
        super(posx, posy);
        scorePoints = 10;
        lifePoints = 1;
    }

    /**
     *
     * @return Returns Shot object with y coordinate of alien and x + 17 coordinate (so that the shot is from the middle of the bitmap
     */
    public Shot shoot(){
            return new Shot(posx + 17, posy, "down");
    }

    @Override
    public BufferedImage getImage() {
        return Alien.image;
    }

    /**
     * Deprecated
     */
    public void destroy(){
        Stroke stroke1 = new BasicStroke(2f);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(stroke1);

        g2d.drawRect(posx, posy, 10, 10);
    }

}
