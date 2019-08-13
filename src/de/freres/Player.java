package de.freres;


import java.awt.*;

public class Player extends Token {
    private String name;
    private int score;

    public Player(String name, int posx, int posy){
        super(posx, posy);
        this.name = name;
        livePoints = 3;
    }
}