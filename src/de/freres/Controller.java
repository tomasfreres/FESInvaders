package de.freres;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Controller
 */
public class Controller extends Canvas {


    private ArrayList<Alien> aliens;

    private ArrayList<Alien> alienRowOne;
    private ArrayList<Alien> alienRowTwo;


    private ArrayList<Shot> shots;
    private Player player;
    private static boolean right;
    private static boolean left;
    private static boolean space;
    private double shootprobebility = 0.99;
    private boolean moveIt = false;
    private boolean moveItToTheBeat = true;

    JFrame field;
    private ArrayList<Shield> shield;

    /**
     * @param eingabe defines the player's name
     * @throws InterruptedException
     */
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

    /**
     * Initiates the gameloop and generates first set of aliens, positions the player and adds the shields to the arraylist
     */
    public void start() {


        alienRowOne = new ArrayList<>();
        alienRowTwo = new ArrayList<>();

        for (int i = 50; i < 360; i += 40) {
            alienRowOne.add(new Alien(i, 100));
            alienRowTwo.add(new Alien(i, 50));
        }

        shootprobebility = 0.99;

        shield = new ArrayList<>();
        shield.add(new Shield(100, 360));
        shield.add(new Shield(200, 360));
        shield.add(new Shield(300, 360));


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

    /**
     * refreshDisplay features the gameloop and draws the objects onto the canvas
     *
     * @throws InterruptedException
     * @throws IOException
     * @throws URISyntaxException
     */
    public void refreshDisplay() throws InterruptedException, IOException, URISyntaxException {

        while (true) {
            Graphics graphicsContext = this.getGraphics();

            BufferedImage bimage = new BufferedImage(450, 600,
                    BufferedImage.TYPE_BYTE_INDEXED);

            TimeUnit.MILLISECONDS.sleep(50);

            Graphics g = bimage.getGraphics();


            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.black);
            g2d.fillRect(0, 0, 450, 600);
            g2d.setColor(Color.white);
            g2d.drawString("Player: " + player.getName(), 20, 20);
            g2d.drawString("Score: " + player.getScore(), 20, 40);
            g2d.drawString("Lives: " + player.getLifePoints(), 370, 20);

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
                        case 'v':
                            Controller.space = true;
                            break;
                    }
                }
            });

            if (right) {
                player.move("right");
            }
            if (left) {
                player.move("left");
            }
            if (space) {
                shots.add(player.shoot());
                player.payShot();
            }

            Controller.right = false;
            Controller.left = false;

            //--------------------------------------------------------- Berechnet Treffer
            for (int i = 0; i < shots.size(); i++) {
                shots.get(i).shotPosition();
                if (shots.get(i).getY() > 0 && shots.get(i).getY() < 600) {

                    for (int j = 0; j < alienRowOne.size(); j++) {
                        if (!shots.isEmpty() && i < shots.size()) {
                            if (alienRowOne.get(j).hitbox(shots.get(i))) {
                                shots.remove(i);
                            } else {
                                shots.get(i).draw(g);
                            }


                        }
                    }

                    for (int k = 0; k < alienRowTwo.size(); k++) {
                        if (!shots.isEmpty() && i < shots.size()) {
                            if (alienRowTwo.get(k).hitbox(shots.get(i))) {
                                shots.remove(i);
                            } else {
                                shots.get(i).draw(g);
                            }

                        }
                    }

                    for (int j = 0; j < shield.size(); j++) {
                        if (!shots.isEmpty() && i < shots.size()) {
                            if (shield.get(j).hitbox(shots.get(i))) {
                                shots.remove(i);
                            } else {
                                shots.get(i).draw(g);
                            }
                        }
                    }

                    if (!shots.isEmpty() && i < shots.size()) {
                        player.hitbox(shots.get(i));
                    }

                } else {
                    shots.remove(i);
                }
            }

            //--------------------------------------------- Löscht Alien wenn Lifepoints = 0
            for (int i = 0; i < alienRowOne.size(); i++) {
                if (alienRowOne.get(i).getLifePoints() == 0) {
                    alienRowOne.remove(i);
                    player.settleScore();
                } else {
                    alienRowOne.get(i).draw(g);
                }

            }


            for (int i = 0; i < alienRowTwo.size(); i++) {
                if (alienRowTwo.get(i).getLifePoints() == 0) {
                    alienRowTwo.remove(i);
                    player.settleScore();
                } else {
                    alienRowTwo.get(i).draw(g);
                }
            }

            //--------------------------------------------- Löscht Schild wenn Lifepoints = 0
            for (int i = 0; i < shield.size(); i++) {
                if (shield.get(i).getLifePoints() == 0) {
                    shield.remove(i);
                } else {
                    shield.get(i).draw(g);
                }
            }


            //---------------------------------------------Spawnt Aliens neu
            if (alienRowOne.isEmpty()) {
                for (Alien alien : alienRowTwo
                ) {
                    alien.setY(100);
                }

                if(alienRowTwo.isEmpty()) {
                    shootprobebility = shootprobebility - 0.001;
                }
            }


            if (alienRowTwo.size() == 0) {

                for (int i = 50; i < 360; i += 40) {
                    alienRowOne.add(new Alien(i, 100));
                    alienRowTwo.add(new Alien(i, 50));
                }

            }



            //--------------------------------------------- Zeichnet Spieler

            if (player.getLifePoints() > 0) {
                player.draw(g);
            } else {
                graphicsContext.drawImage(ImageIO.read(Alien.class.getResource("/Gameover.png")), 0, 50, 450, 550, null);
                g2d.drawString("Score: " + player.getScore(), 20, 40);
                g2d.drawString("Lives: " + player.getLifePoints(), 370, 20);

                String option[] = {"Neustart", "Beenden"};

                if (JOptionPane.showOptionDialog(null, "Wollen Sie erneut spielen?", "Game Over", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.YES_NO_CANCEL_OPTION, null, option, option[0]) == JOptionPane.YES_OPTION) {
                    shots.clear();
                    start();
                } else {
                    break;
                }
            }
            space = false;


            //---------------------------------------------- Verwaltet Bewegung der Aliens

            if (moveIt){
                letAliensMoveLeft();
                if (!alienRowOne.isEmpty()) {
                    if (alienRowOne.get(0).getX() <= 0) {
                        moveIt = false;
                    }
                }

            } else {
                letAliensMoveRight();
                if (!alienRowOne.isEmpty()) {
                    if (alienRowOne.get(alienRowOne.size() - 1).getX() >= 400) {
                        moveIt = true;
                    }
                }
            }


            if (moveItToTheBeat){
                letOtherAliensMoveLeft();
                if (alienRowTwo.get(0).getX() <= 0) {
                    moveItToTheBeat=false;
                }

            }else {
                letOtherAliensMoveRight();
                if (alienRowTwo.get(alienRowTwo.size()-1).getX() >= 400){
                    moveItToTheBeat=true;
                }
            }



            letAliensShoot();


            //--------------------------------------------- Löscht graphischen Kontext nach Durchlauf
            graphicsContext.drawImage(bimage, 0, 0, null);
            graphicsContext.dispose();
            g.dispose();
        }

    }

    /**
     * Lets every alien shoot with an probability of 0,01%
     */
    public void letAliensShoot() {
        if (alienRowOne.size() > 0) {
            for (Alien k : alienRowOne
            ) {
                if (Math.random() > shootprobebility) {
                    shots.add(k.shoot());
                }
            }
        } else {
            for (Alien k : alienRowTwo) {
                if (Math.random() > shootprobebility) {
                    shots.add(k.shoot());

                }

            }
        }
    }

    public void letAliensMoveLeft() {
            for (Alien k : alienRowOne) {
                k.tinyMove("left");
            }
    }

    public void letAliensMoveRight() {
            for (Alien k : alienRowOne) {
                k.tinyMove("right");
            }
    }

    public void letOtherAliensMoveLeft() {
        for (Alien k : alienRowTwo) {
            k.tinyMove("left");
        }
    }

    public void letOtherAliensMoveRight() {
        for (Alien k : alienRowTwo) {
            k.tinyMove("right");
        }
    }
}
