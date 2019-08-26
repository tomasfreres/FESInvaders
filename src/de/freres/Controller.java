package de.freres;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Controller extends Canvas {


    private ArrayList<Alien> aliens;
    private ArrayList<Shot> shots;
    private Player player;
    private static boolean right;
    private static boolean left;
    private static boolean space;
    JFrame field;
    private ArrayList<Shield> shield;

    public Controller() throws InterruptedException {
        this.aliens = new ArrayList<>();
        this.shots = new ArrayList<>();
        this.shield = new ArrayList<>();
        //this.player = new Player();

        field = new JFrame("FESInvaders");

        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        field.setSize(450, 600);

        field.add(this);

        field.setVisible(true);

        aliens.add(new Alien(30, 50));
        aliens.add(new Alien(70, 50));
        aliens.add(new Alien(110, 50));
        aliens.add(new Alien(150, 50));
        aliens.add(new Alien(190, 50));
        aliens.add(new Alien(225, 20));
        aliens.add(new Alien(30, 90));
        aliens.add(new Alien(70, 90));

        shield.add(new Shield(100,360));
        shield.add(new Shield(200,360));
        shield.add(new Shield(300,360));

        this.player = new Player("Ole", 225, 500);



        refreshDisplay();
    }


    public void refreshDisplay() throws InterruptedException {

        while(true){
            Graphics g = this.getGraphics();
            TimeUnit.MILLISECONDS.sleep(50);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.black);
            g2d.fillRect(0,0,450,600);
            g2d.setColor(Color.white);
            g2d.drawString("Score: " +player.getScore(), 20, 20);


            field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    switch (e.getKeyChar()) {
                        case 'd':
                            Controller.right = true;
                            break;
                        case 'a':
                            Controller.left = true;
                            break;
                        case 'v': Controller.space = true;
                            break;
                    }
                }
            });

            if(right){
                player.move("right");
            }
            if(left){
                player.move("left");
            }
            if(space){
                shots.add(player.shoot());
                player.payShot();
            }

            Controller.right = false;
            Controller.left = false;

            for(int i = 0; i < shots.size(); i++){
                shots.get(i).shotPosition();
                if(shots.get(i).getY() > 0 && shots.get(i).getY() < 600){

                    for(int j = 0; j < aliens.size(); j++) {
                        if(!shots.isEmpty() && i < shots.size()) {
                            if (aliens.get(j).hitbox(shots.get(i))) {
                                shots.remove(i);
                            } else {
                                shots.get(i).draw(g);
                            }
                        }
                    }
                    for(int j = 0; j < shield.size(); j++) {
                        if(!shots.isEmpty() && i < shots.size()) {
                            if (shield.get(j).hitbox(shots.get(i))) {
                                shots.remove(i);
                            } else {
                                shots.get(i).draw(g);
                            }
                        }
                    }
                }
                else{
                    shots.remove(i);
                }
            }

            for(int i = 0; i < aliens.size(); i++){
                if(aliens.get(i).getLifePoints() == 0){
                    aliens.remove(i);
                    player.settleScore();
                }
                else{
                    aliens.get(i).draw(g);
                }
            }
            for(int i = 0; i < shield.size(); i++){
                if(shield.get(i).getLifePoints() == 0){
                    shield.remove(i);
                }
                else{
                    shield.get(i).draw(g);
                }
            }
            player.draw(g);
            space = false;

            g.dispose();
        }

    }
}
