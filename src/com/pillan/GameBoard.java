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
    JLabel label = new JLabel("Type the amount of players!");
    JTextField field = new JTextField();
    JButton submit1 = new JButton("Submit");

    //second window
    JFrame frame2 = new JFrame();
    JPanel panel = new JPanel();
    JButton submit2 = new JButton("Submit Names");

    //third window
    JFrame frame3 = new JFrame();
    JPanel buttons = new JPanel();
    JPanel startPanel = new JPanel();
    JLabel labelName = new JLabel("Name", SwingConstants.CENTER);
    JLabel labelDrinkOrNot = new JLabel("", SwingConstants.CENTER);
    JTextArea log = new JTextArea(100, 40);
    JButton higher = new JButton("Higher");
    JButton lower = new JButton("Lower");
    JButton startKnapp = new JButton("Start");

    GameBoard() {

        // frame 1
        frame1.setSize(400, 300);
        frame1.setLayout(new GridLayout(3, 1));
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
        frame2.setSize(400, 500);
        panel.setLayout(new GridLayout(amountOfPlayers, 1));
        frame2.setLocationRelativeTo(null);

        submit2.addActionListener(e -> {
            iterateOverJTextFields(panel);
            playerList.createPlayers(personNameList);
            newGame = new Game(playerList);
            frame2.setVisible(false);
            frame3.setVisible(true);

        });

        //frame 3
        frame3.setLayout(new BorderLayout());
        frame3.setLocationRelativeTo(null);
        frame3.setSize(400, 500);
        frame3.add(log, BorderLayout.CENTER);
        frame3.add(startPanel, BorderLayout.NORTH);
        startPanel.add(startKnapp);
        startPanel.setVisible(true);
        buttons.setLayout(new GridLayout(1, 3));
        buttons.setVisible(false);

        startKnapp.addActionListener(e -> {

            labelName.setText(newGame.getCurrentPlayer().getName());
            labelDrinkOrNot.setText(" " + newGame.getNumber());
            firstNameAndDrink = newGame.getCurrentPlayer().getName();
            newGame.renewNumbers();

            startPanel.setVisible(false);
            frame3.add(buttons, BorderLayout.NORTH);
            buttons.setVisible(true);
            buttons.add(labelName);
            buttons.add(lower);
            buttons.add(labelDrinkOrNot);
            buttons.add(higher);


            higher.addActionListener(f -> {

                if (newGame.guess(true).equals("correct")) {
                    log.append(newGame.getCurrentPlayer().getName() + " - DRINK\n");
                } else {
                    log.append(newGame.getCurrentPlayer().getName() + " - NO DRINK\n");
                }

                labelDrinkOrNot.setText(" " + newGame.getNumber());

                newGame.renewNumbers();
                labelName.setText(newGame.getCurrentPlayer().getName());

            });

            lower.addActionListener(f -> {

                if (newGame.guess(false).equals("correct")) {
                    log.append(newGame.getCurrentPlayer().getName() + " - NO DRINK\n");
                } else {
                    log.append(newGame.getCurrentPlayer().getName() + " - DRINK\n");
                }

                labelDrinkOrNot.setText(" " + newGame.getNumber());

                newGame.renewNumbers();
                labelName.setText(newGame.getCurrentPlayer().getName());

            });
        });

    }

    public void createInputList() {
        for (int i = 0; i < amountOfPlayers; i++) {
            panel.add(new JTextField());
        }
    }

    private void iterateOverJTextFields(Container container) {
        for (Component component : container.getComponents()) {
            if (component instanceof JTextField) {
                personNameList.add(((JTextField) component).getText());
            }
        }
    }
}
