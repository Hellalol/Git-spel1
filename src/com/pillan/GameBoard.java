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
    JLabel labelFrame1 = new JLabel("Type the amount of players!");
    JTextField fieldFrame1 = new JTextField();
    JButton submit1Frame1 = new JButton("Submit");

    //second window
    JFrame frame2 = new JFrame();
    JPanel panelFrame2 = new JPanel();
    JButton submit2Frame2 = new JButton("Submit Names");

    //third window
    JFrame frame3 = new JFrame();
    JPanel buttonsFrame3 = new JPanel();
    JPanel startPanelFrame3 = new JPanel();
    JLabel labelNameFrame3 = new JLabel("Name", SwingConstants.CENTER);
    JLabel labelDrinkOrNotFrame3 = new JLabel("", SwingConstants.CENTER);
    JTextArea logFrame3 = new JTextArea(100, 40);
    JButton higherFrame3 = new JButton("Higher");
    JButton lowerFrame3 = new JButton("Lower");
    JButton startKnappFrame3 = new JButton("Start");

    GameBoard() {

        // frame 1
        frame1.setSize(400, 300);
        frame1.setLayout(new GridLayout(3, 1));
        frame1.setVisible(true);
        frame1.setLocationRelativeTo(null);

        frame1.add(labelFrame1);
        frame1.add(fieldFrame1);
        frame1.add(submit1Frame1);

        submit1Frame1.addActionListener(e -> {

            String inputNumber = fieldFrame1.getText();
            amountOfPlayers = Integer.parseInt(inputNumber);
            frame1.setVisible(false);
            frame2.setVisible(true);
            createInputList();
            panelFrame2.add(submit2Frame2);

        });

        // frame 2
        frame2.add(panelFrame2);
        frame2.setSize(400, 500);
        panelFrame2.setLayout(new GridLayout(amountOfPlayers, 1));
        frame2.setLocationRelativeTo(null);

        submit2Frame2.addActionListener(e -> {
            iterateOverJTextFields(panelFrame2);
            playerList.createPlayers(personNameList);
            newGame = new Game(playerList);
            frame2.setVisible(false);
            frame3.setVisible(true);

        });

        //frame 3
        frame3.setLayout(new BorderLayout());
        frame3.setLocationRelativeTo(null);
        frame3.setSize(400, 500);
        frame3.add(logFrame3, BorderLayout.CENTER);
        frame3.add(startPanelFrame3, BorderLayout.NORTH);
        startPanelFrame3.add(startKnappFrame3);
        startPanelFrame3.setVisible(true);
        buttonsFrame3.setLayout(new GridLayout(1, 3));
        buttonsFrame3.setVisible(false);

        startKnappFrame3.addActionListener(e -> {

            labelNameFrame3.setText(newGame.getCurrentPlayer().getName());
            labelDrinkOrNotFrame3.setText(" " + newGame.getNumber1());
            firstNameAndDrink = newGame.getCurrentPlayer().getName();


            startPanelFrame3.setVisible(false);
            frame3.add(buttonsFrame3, BorderLayout.NORTH);
            buttonsFrame3.setVisible(true);
            buttonsFrame3.add(labelNameFrame3);
            buttonsFrame3.add(lowerFrame3);
            buttonsFrame3.add(labelDrinkOrNotFrame3);
            buttonsFrame3.add(higherFrame3);


            higherFrame3.addActionListener(f -> {

                if (newGame.guess(true).equals("correct")) {
                    logFrame3.append(newGame.getCurrentPlayer().getName() + " - NO DRINK, " + "the number was: " + newGame.getNumber2() + "\n" );
                } else {
                    logFrame3.append(newGame.getCurrentPlayer().getName() + " - DRINK, " + "the number was: " + newGame.getNumber2() + "\n" );
                }

                newGame.renewNumbers();
                labelDrinkOrNotFrame3.setText(" " + newGame.getNumber1());

                labelNameFrame3.setText(newGame.getCurrentPlayer().getName());

            });


            lowerFrame3.addActionListener(f -> {

                if (newGame.guess(false).equals("correct")) {
                    logFrame3.append(newGame.getCurrentPlayer().getName() + " - NO DRINK, " + "the number was: " + newGame.getNumber2() + "\n" );
                } else {
                    logFrame3.append(newGame.getCurrentPlayer().getName() + " - DRINK, " + "the number was: " + newGame.getNumber2() + "\n" );
                }

                newGame.renewNumbers();
                labelDrinkOrNotFrame3.setText(" " + newGame.getNumber1());

                labelNameFrame3.setText(newGame.getCurrentPlayer().getName());

            });
        });

    }

    public void createInputList() {
        for (int i = 0; i < amountOfPlayers; i++) {
            panelFrame2.add(new JTextField());
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
