package de.freres;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Controller extends Canvas {


    private ArrayList<Alien> aliens;
    private ArrayList<Shot> shots;
    private Player player;
    JFrame field;

    public Controller() throws InterruptedException {
        this.aliens = new ArrayList<>();
        this.shots = new ArrayList<>();
        //this.player = new Player();

        field = new JFrame("FESInvaders");

        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        field.setSize(450, 600);

        field.add(this);

        field.setVisible(true);

        shots.add(new Shot(225,300, "up"));
    }


    public void refreshDisplay(Graphics g) throws InterruptedException {
        for(int i = 0; i <200; i++){
            TimeUnit.MILLISECONDS.sleep(100);
            field.repaint();
            field.revalidate();

            for (Alien k: aliens) {
                k.draw(g);
            }
            for(Shot k: shots){
                k.shotPosition();
                k.draw(g);
            }

           // player.draw(g);
        }
    }


    public void paint(Graphics g){


        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setBackground(Color.black);
        Alien a = new Alien(30, 50);
        Alien b = new Alien(50, 50);
        Alien c = new Alien(70, 50);
        Alien d = new Alien(90, 50);
        Alien e = new Alien(110, 50);
        Alien f = new Alien(30, 70);
        Alien ge = new Alien(50, 70);


        for(Shot k: shots){
            k.draw(g);
        }


        a.draw(g);
        b.draw(g);
        c.draw(g);
        d.draw(g);
        e.draw(g);
        f.draw(g);
        ge.draw(g);
        //sa.draw(g);

        g.drawString("Highscore: ", 130, 50);

        c.destroy();

        //Player player = new Player("Gott", 200, 450);
        //player.draw(g);

     /*   try {
            this.refreshDisplay(g);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }*/
    }



}
