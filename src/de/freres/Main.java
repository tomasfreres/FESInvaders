package de.freres;

import javax.swing.*;
import javax.swing.JFrame;

public class Main extends JFrame{

    public static void main(String[] args) throws InterruptedException {

        String eingabe = JOptionPane.showInputDialog(null,"Geben Sie Ihren Namen ein");

        Object[] options = {"Ich akzeptiere", "Ich lehne ab"};

        if(JOptionPane.showOptionDialog(null, "Hiermit bestätigen Sie unsere Datenschutzrichtliien",
                "Datenschutzrichtlinien", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]) ==   JOptionPane.YES_OPTION){
            Controller controller = new Controller(eingabe);
        }
        else{
            JOptionPane.showMessageDialog(null ,"Sie haben keinen Zugang zu dem Spiel");
        }
    }


}
