package de.freres;

public abstract class Token {

    protected int livePoints;
    protected int shootFrequency;
    protected Gridfield gridfield;
    protected int damage;

    public void shoot(){

    }

    public void getDamage(int damage){
        this.damage -= damage;
    }

}
