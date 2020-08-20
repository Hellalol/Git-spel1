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
    String firstNameAndDrink;

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
    JPanel knapparna = new JPanel();
    JLabel labelName = new JLabel("Namn", SwingConstants.CENTER);
    JLabel labelDrickOrNot = new JLabel("",SwingConstants.CENTER);
    JTextArea logg = new JTextArea(100,40);
    JButton hogre = new JButton("Högre");
    JButton lagre = new JButton("Lägre");

    GameBoard(){

        // frame 1
        frame1.setSize(400,300);
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
            labelDrickOrNot.setText(" " + newGame.getNumber());
            firstNameAndDrink = newGame.getCurrentPlayer().getName();

        });

        //frame 3
        frame3.setLayout(new BorderLayout());
        frame3.add(knapparna,BorderLayout.NORTH);

        knapparna.setLayout(new GridLayout(1,3));
        frame3.setLocationRelativeTo(null);
        frame3.setSize(400,500);
        frame3.add(logg,BorderLayout.CENTER);
        knapparna.add(labelName);
        knapparna.add(lagre);
        knapparna.add(labelDrickOrNot);
        knapparna.add(hogre);


        hogre.addActionListener(e->{

            if (newGame.guess(true).equals("correct")){
                logg.append(labelName.getText() + "- INTE DRICK\n");
                //logg.append(newGame.getCurrentPlayer().getName() + " - INTE DRICK\n");
            }else{
                logg.append(labelName.getText() + "- DRICK\n");
                //logg.append(newGame.getCurrentPlayer().getName() + " - DRICK\n");
            }
            labelDrickOrNot.setText(" " + newGame.getNumber());

            newGame.renewNumbers();
            labelName.setText(newGame.getCurrentPlayer().getName());
        });

        lagre.addActionListener(e -> {

            if (newGame.guess(false).equals("correct")){
                logg.append(labelName.getText() + "- INTE DRICK\n");
                //logg.append(newGame.getCurrentPlayer().getName() + " - INTE DRICK\n");
            }else{
                logg.append(labelName.getText() + "- DRICK\n");
                //logg.append(newGame.getCurrentPlayer().getName() + " - DRICK\n");
            }
            labelDrickOrNot.setText(" " + newGame.getNumber());

            newGame.renewNumbers();
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
