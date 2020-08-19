package com.pillan;

import javax.swing.*;
import java.awt.*;


public class GameBoard {

    JFrame f = new JFrame();
    JLabel label = new JLabel("Välj hur många spelare!");
    JTextField field = new JTextField();
    JButton button = new JButton("starta");

    GameBoard(){
        f.setSize(400,500);
        f.setLayout(new GridLayout(3,2));
        f.setVisible(true);

        f.add(label);
        f.add(field);
        f.add(button);
    }
}
