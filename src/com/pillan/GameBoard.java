package com.pillan;

import javax.swing.*;
import java.awt.*;


public class GameBoard {

    int amountOfPlayers;


    //first window
    JFrame frame1 = new JFrame();
    JLabel label = new JLabel("Välj hur många spelare!");
    JTextField field = new JTextField();
    JButton button = new JButton("starta");

    //second window
    JFrame frame2 = new JFrame();



    GameBoard(){
        frame1.setSize(400,500);
        frame1.setLayout(new GridLayout(3,1));
        frame1.setVisible(true);
        frame1.setLocationRelativeTo(null);

        frame1.add(label);
        frame1.add(field);
        frame1.add(button);

        button.addActionListener(e -> {

            String inputNumber = field.getText();
            amountOfPlayers = Integer.parseInt(inputNumber);
            frame1.setVisible(false);
            frame2.setVisible(true);

        });

        frame2.setSize(400,500);
        frame2.setLayout(new GridLayout(1,amountOfPlayers));
        frame2.setLocationRelativeTo(null);

    }

    public void createInputList(){
        for (int i = 0; i < amountOfPlayers; i++) {
            frame2.add(new JTextField());
        }
    }

}
