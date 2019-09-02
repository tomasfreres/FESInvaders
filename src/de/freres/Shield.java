package de.freres;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Shield extends Token{
     protected BufferedImage image;

    // Creates Shield with 10 Lifepoints

    /**
     *
     * @param posx Position on the X-axis
     * @param posy Position on the Y-axis
     */
    public Shield(int posx, int posy){
        super(posx, posy);
        lifePoints = 10;
        try {
            image = ImageIO.read(Shield.class.getResource("/Shield_10_hp.bmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Tests if the given shot is inside bounds of hitbox
     * @param shot
     * @return boolean if object is being shot
     */
    @Override
    public boolean hitbox(Shot shot) {
        if(shot.getX() >= posx && shot.getX() < posx + 40 && shot.getY() == posy){
            lifePoints--;
            if(lifePoints > 0) {
                try {
                    image = ImageIO.read(Shield.class.getResource("/Shield_" + this.lifePoints + "_hp.bmp"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return true;    }
        else {
            return false;
        }
    }

    @Override
    public BufferedImage getImage() {
        return image;
    }
}
