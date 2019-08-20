package de.freres;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Controller extends Canvas {


    private ArrayList<Alien> aliens;
    private ArrayList<Shot> shots;
    private Player player;
    JFrame field;
    private KeyEventClass keyListener;

    public Controller() throws InterruptedException {
        this.aliens = new ArrayList<>();
        this.shots = new ArrayList<>();
        this.player = new Player("Gott", 350, 250);

        field = new JFrame("FESInvaders");

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
        while(true){
            TimeUnit.MILLISECONDS.sleep(41);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.black);
            g2d.fillRect(0,0,450,600);

            for (Alien k: aliens) {
                k.draw(g);
            }
            for(Shot k: shots){
                k.shotPosition();


                k.draw(g); 
}

            player.draw(g);
        }


    public void paint(Graphics g){


        aliens.add(new Alien(30, 50));
        aliens.add(new Alien(50, 50));
        aliens.add(new Alien(70, 50));
        aliens.add(new Alien(90, 50));
        aliens.add(new Alien(110, 50));
        aliens.add(new Alien(30, 70));
        aliens.add(new Alien(50, 70));

        player = new Player("Gott", 200, 450);
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
