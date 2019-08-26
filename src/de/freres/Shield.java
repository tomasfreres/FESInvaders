package de.freres;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Shield extends Token{
    static protected BufferedImage image;
    static {
        try {
            image = ImageIO.read(Alien.class.getResource("/Alien.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Creates Shield with 10 Lifepoints

    public Shield(int posx, int posy){
        super(posx, posy);
        lifePoints = 10;

    }


    @Override
    public boolean hitbox(Shot shot) {
        if(shot.getX() >= posx && shot.getX() < posx + 15 && shot.getY() == posy){
            lifePoints--;
            return true;    }
        else {
            return false;
        }
    }

    @Override
    public BufferedImage getImage() {
        return Alien.image;
    }
}
