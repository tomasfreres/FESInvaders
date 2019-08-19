package de.freres;

<<<<<<< Updated upstream
import javax.swing.*;
=======
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
>>>>>>> Stashed changes
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Controller {


    private Gamefield gamefield;
    private ArrayList<Alien> aliens;
    private ArrayList<Shot> shots;
    private Player player;
    private KeyEventClass keyListener;

<<<<<<< Updated upstream
    public Controller() throws InterruptedException {
        this.gamefield = new Gamefield();
        this.aliens = new ArrayList<>();
        this.shots = new ArrayList<>();
        //this.player = new Player();

        JFrame field = new JFrame("FESInvaders");

        field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        field.setSize(450, 600);

        field.add(gamefield);

        field.setVisible(true);

        shots.add(new Shot(225,300, "up"));

        refreshDisplay();
=======
    public Controller() {
        this.gamefield = new Gamefield();
        this.aliens = new ArrayList<>();
        this.player = new Player("Gott", 200, 450 );
        this.keyListener = new KeyEventClass(this);
    }

    public void movePlayer(String move){
        player.move(move);
>>>>>>> Stashed changes
    }


    public void refreshDisplay() throws InterruptedException {
        //while(true){
          //  TimeUnit.MILLISECONDS.sleep(500);
            gamefield.getGraphicsContext().fillRect(0,0,450,600);

            for (Alien k: aliens) {
                k.draw(gamefield.getGraphicsContext());
            }
            for(Shot k: shots){
                k.shotPosition();
                k.draw(gamefield.getGraphicsContext());
            }

            //player.draw(gamefield.getGraphicsContext());
        //}
    }





}
