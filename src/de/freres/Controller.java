package de.freres;

import com.sun.source.tree.WhileLoopTree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static java.awt.event.KeyEvent.*;

public class Controller extends Canvas implements Runnable {


    private ArrayList<Alien> aliens;
    private ArrayList<Shot> shots;
    private Player player;
    JFrame field;
    private Controller controller;
    private KeyEventClass keyManager;
    private KeyEventClass keyListener;

    public Controller() throws InterruptedException {
        this.aliens = new ArrayList<>();
        this.shots = new ArrayList<>();
        this.player = new Player("Gott", 350, 250);
        this.keyManager = new KeyEventClass();

        field = new JFrame("FESInvaders");

        field.addKeyListener(keyManager);
        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        field.setSize(450, 600);

        field.add(this);

        field.setVisible(true);

        shots.add(new Shot(225, 400, "up"));
        shots.add(new Shot(300, 0, "down"));

        aliens.add(new Alien(30, 50));
        aliens.add(new Alien(50, 50));
        aliens.add(new Alien(70, 50));
        aliens.add(new Alien(90, 50));
        aliens.add(new Alien(110, 50));
        aliens.add(new Alien(30, 70));
        aliens.add(new Alien(50, 70));
    }

    public void startThread(){
        System.out.println("start");
        new Thread(this).start();
    }

    void update() {
        keyManager.update(this.player);
    }

    @Override
    public void run() {
        System.out.println("run Methode");
        try {
            refreshDisplay();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void refreshDisplay() throws InterruptedException {

        System.out.println("refreshDisplay");

        Graphics g = this.getGraphics();

        while (true) {

            TimeUnit.MILLISECONDS.sleep(41);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.black);
            g2d.fillRect(0, 0, 450, 600);

            update();

            for (Alien k : aliens) {
                k.draw(g);
            }

            for (int i = 0; i < shots.size(); i++) {
                shots.get(i).shotPosition();

                if (shots.get(i).getY() > 0 && shots.get(i).getY() < 600) {
                    shots.get(i).draw(g);
                } else {
                    shots.remove(i);
                }
            }
            if(keyManager.down){
                System.out.println("Down registered");
            }

            player.draw(g);
            keyManager.reset();
        }
    }


    public void alienshot() {
        int pposx = this.player.getX();
        ArrayList<Integer> aposx = new ArrayList<>();


        for (Alien k : aliens) {
            aposx.add(k.getX());
        }
    }

    public void paint(){

    }
}
