package de.freres;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Controller {


    private Gamefield gamefield;
    private ArrayList<Alien> aliens;
    private Player player;

    public Controller() throws InterruptedException {
        this.gamefield = new Gamefield();
        this.aliens = new ArrayList<>();
        //this.player = new Player();

        refreshDisplay();
    }


    public void refreshDisplay() throws InterruptedException {
        while(true){
            TimeUnit.MILLISECONDS.sleep(41);

            for (Alien k: aliens) {
                k.draw(gamefield.getGraphicsContext());
            }

            player.draw(gamefield.getGraphicsContext());
        }
    }





}
