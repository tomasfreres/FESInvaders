package de.freres;

import java.util.ArrayList;

public class Controller {


    private Gamefield gamefield;
    private ArrayList<Alien> aliens;
    private Player player;

    public Controller(){
        this.gamefield = new Gamefield();
        this.aliens = new ArrayList<>();
        this.player = new Player();
    }
}
