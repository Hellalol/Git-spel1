package com.pillan;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class GameBoard {

    int amountOfPlayers;
    PlayerList playerList = new PlayerList();
    List<String> personNameList = new ArrayList<>();
    Game newGame;

    //first window
    JFrame frame1 = new JFrame();
    JLabel label = new JLabel("Välj hur många spelare!");
    JTextField field = new JTextField();
    JButton submit1 = new JButton("Submit!");

    //second window
    JFrame frame2 = new JFrame();
    JPanel panel = new JPanel();
    JButton submit2 = new JButton("start game!");

    //third window
    JFrame frame3 = new JFrame();
    JLabel labelName = new JLabel("Namn");
    JLabel labelDrickOrNot = new JLabel();
    JButton hogre = new JButton("Högre");
    JButton lagre = new JButton("Lägre");

    GameBoard(){

        // frame 1
        frame1.setSize(400,500);
        frame1.setLayout(new GridLayout(3,1));
        frame1.setVisible(true);
        frame1.setLocationRelativeTo(null);

        frame1.add(label);
        frame1.add(field);
        frame1.add(submit1);

        submit1.addActionListener(e -> {

            String inputNumber = field.getText();
            amountOfPlayers = Integer.parseInt(inputNumber);
            frame1.setVisible(false);
            frame2.setVisible(true);
            createInputList();
            panel.add(submit2);

        });

        // frame 2
        frame2.add(panel);
        frame2.setSize(400,500);
        panel.setLayout(new GridLayout(amountOfPlayers,1));
        frame2.setLocationRelativeTo(null);

        submit2.addActionListener(e -> {
            iterateOverJTextFields(panel);
            playerList.createPlayers(personNameList);
            newGame = new Game(playerList);
            frame2.setVisible(false);
            frame3.setVisible(true);
            labelName.setText(newGame.getCurrentPlayer().getName());

        });

        //frame 3
        frame3.setLayout(new GridLayout(1,3));
        frame3.setLocationRelativeTo(null);
        frame3.setSize(400,100);
        frame3.add(labelName);
        frame3.add(lagre);
        frame3.add(hogre);
        frame3.add(labelDrickOrNot);


        hogre.addActionListener(e->{

            if (newGame.guess(true).equals("correct")){
                labelDrickOrNot.setText("inte drick");
            }else if(newGame.guess(true).equals("incorrect")){
                labelDrickOrNot.setText("drick");
            }else{
                labelDrickOrNot.setText("alla dricker");
            }

            //newGame.renewNumbers();
            labelName.setText(newGame.getCurrentPlayer().getName());
        });

        lagre.addActionListener(e -> {

            if (newGame.guess(false).equals("correct")){
                labelDrickOrNot.setText("inte drick");
            }else if(newGame.guess(false).equals("incorrect")){
                labelDrickOrNot.setText("drick");
            }else{
                labelDrickOrNot.setText("alla dricker");
            }
            //newGame.renewNumbers();
            labelName.setText(newGame.getCurrentPlayer().getName());
        });
    }


    public void createInputList(){
        for (int i = 0; i < amountOfPlayers; i++) {
            panel.add(new JTextField());
        }
    }

    private void iterateOverJTextFields(Container container){
        for (Component component : container.getComponents()){
            if (component instanceof JTextField){
                personNameList.add(((JTextField) component).getText());
            }
        }
    }
}
