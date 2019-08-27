package de.freres;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
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

    public Controller(String eingabe) throws InterruptedException {
        this.aliens = new ArrayList<>();
        this.shots = new ArrayList<>();
        //this.player = new Player();

        field = new JFrame("FESInvaders");

        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        field.setSize(450, 600);

        field.add(this);

        field.setVisible(true);

        this.player = new Player(eingabe, 225, 500);

        start();
    }

    public void start(){
        aliens = new ArrayList<>();
        aliens.add(new Alien(30, 50));
        aliens.add(new Alien(70, 50));
        aliens.add(new Alien(110, 50));
        aliens.add(new Alien(150, 50));
        aliens.add(new Alien(190, 50));
        aliens.add(new Alien(225, 20));
        aliens.add(new Alien(30, 90));
        aliens.add(new Alien(70, 90));

        shield = new ArrayList<>();
        shield.add(new Shield(100,360));
        shield.add(new Shield(200,360));
        shield.add(new Shield(300,360));


       this.player.setX(225);
       this.player.setY(500);
       this.player.setScore(0);
       this.player.setLifePoints(3);


        try {
            refreshDisplay();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void refreshDisplay() throws InterruptedException, IOException, URISyntaxException {

        while(true){
            Graphics g = this.getGraphics();
            TimeUnit.MILLISECONDS.sleep(50);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.black);
            g2d.fillRect(0,0,450,600);
            g2d.setColor(Color.white);
            g2d.drawString("Player: " + player.getName(),10,20);
            g2d.drawString("Score: " +player.getScore(), 10, 40);

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

            //--------------------------------------------------------- Berechnet Treffer
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

            //--------------------------------------------- Löscht Alien wenn Lifepoints = 0
            for(int i = 0; i < aliens.size(); i++){
                if(aliens.get(i).getLifePoints() == 0){
                    aliens.remove(i);
                    player.settleScore();
                }
                else{
                    aliens.get(i).draw(g);
                }
            }
            //--------------------------------------------- Löscht Schild wenn Lifepoints = 0
            for(int i = 0; i < shield.size(); i++){
                if(shield.get(i).getLifePoints() == 0){
                    shield.remove(i);
                }
                else{
                    shield.get(i).draw(g);
                }
            }



            //--------------------------------------------- Zeichnet Spieler



            if (player.getLifePoints() > 0){
            player.draw(g);}
            else{
                g2d.drawImage(ImageIO.read(Alien.class.getResource("/gameover.jpg")), 50, 100, 300, 300, null);

                String option[]= {"Neustart", "Beenden"};

                if(JOptionPane.showOptionDialog(null, "Wollen Sie erneut spielen?", "Game Over", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.YES_NO_CANCEL_OPTION, null, option, option[0] )== JOptionPane.YES_OPTION){

                        start();
                }else{
                    break;
                }
            }
            space = false;
            //--------------------------------------------- Löscht graphischen Kontext nach Durchlauf
            g.dispose();
        }

    }
}
