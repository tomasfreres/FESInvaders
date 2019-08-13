package de.freres;



public class Player extends Token {
    private String name;
    private int score;


    public Player(String name) {
        this.name = name;
        livePoints = 3;
    }


}