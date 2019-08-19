package de.freres;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Controller {


    private Gamefield gamefield;
    private ArrayList<Alien> aliens;
    private ArrayList<Shot> shots;
    private Player player;
    private KeyEventClass keyListener;

    public Controller() throws InterruptedException {
        this.gamefield = new Gamefield();
        this.aliens = new ArrayList<>();
        this.shots = new ArrayList<>();
        this.player = new Player("Gott", 350, 250);

        JFrame field = new JFrame("FESInvaders");

        field.addKeyListener(new KeyEventClass(this));
        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        field.setSize(450, 600);

        field.add(gamefield);

        field.setVisible(true);

        shots.add(new Shot(225, 300, "up"));
        this.keyListener = new KeyEventClass(this);

        refreshDisplay();
    }

    public void movePlayer(String move){
        player.move(move);
    }


    public void refreshDisplay() throws InterruptedException {
        //while(true){
        Graphics test = gamefield.getGraphicsContext();
        System.out.println("Graphicoutput is null " + test == null);
           // gamefield.getGraphicsContext().fillRect(0,0,450,600);

         /*   for (Alien k: aliens) {
                k.draw(gamefield.getGraphicsContext());
            }
            for(Shot k: shots){
                k.shotPosition();
                k.draw(gamefield.getGraphicsContext());
            } */

            this.player.draw(gamefield.getGraphicsContext());

            //player.draw(gamefield.getGraphicsContext());
        //}
    }





}
