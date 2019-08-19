package de.freres;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Controller extends Canvas {


    private ArrayList<Alien> aliens;
    private ArrayList<Shot> shots;
    private Player player;
    private KeyEventClass keyListener;

    public Controller() throws InterruptedException {
        this.aliens = new ArrayList<>();
        this.shots = new ArrayList<>();
        this.player = new Player("Gott", 350, 250);

        JFrame field = new JFrame("FESInvaders");

        field.addKeyListener(new KeyEventClass(this));
        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        field.setSize(450, 600);

        field.add(this);

        field.setVisible(true);

        shots.add(new Shot(225, 300, "up"));
        this.keyListener = new KeyEventClass(this);
    }

    public void movePlayer(String move){
        player.move(move);
    }


    public void refreshDisplay(Graphics g) throws InterruptedException {
        //while(true){
           //gamefield.getGraphicsContext().fillRect(0,0,450,600);

         /*   for (Alien k: aliens) {
                k.draw(gamefield.getGraphicsContext());
            }
            for(Shot k: shots){
                k.shotPosition();
                k.draw(gamefield.getGraphicsContext());
            } */



           // player.draw(g);
        }


    public void paint(Graphics g){
        Alien a = new Alien(30, 50);
        Alien b = new Alien(50, 50);
        Alien c = new Alien(70, 50);
        Alien d = new Alien(90, 50);
        Alien e = new Alien(110, 50);
        Alien f = new Alien(30, 70);
        Alien ge = new Alien(50, 70);


        Shot sa = new Shot(140,50, "up");

        setBackground(Color.BLACK);
        a.draw(g);
        b.draw(g);
        c.draw(g);
        d.draw(g);
        e.draw(g);
        f.draw(g);
        ge.draw(g);
        sa.draw(g);

        g.drawString("Highscore: ", 130, 50);

        c.destroy();

        Player player = new Player("Gott", 200, 450);
        player.draw(g);

        try {
            this.refreshDisplay(g);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    public int alienshot(){
        int pposx = this.player.getX();
        ArrayList<Integer> aposx = new ArrayList<>();


        for (Alien k: aliens ){
            aposx.add(k.getX());
            }
        }
    }



}
