package com.pillan;

import java.util.Random;

public class Game {

    Random r = new Random();
    private Player currentPlayer;
    private int answer;
    private int number;


    public void generateAnswer () {
        answer = r.nextInt((100)+1);
        //System.out.println("answer" + answer);
    }

    public void generateNumber () {
        number = r.nextInt((100)+1);
        //System.out.println("shown number" + number);
    }


    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public String guess(boolean over) {
        if(answer == number) return "same";
        else if(over && number > answer) return "correct";
        else if(!over && number < answer) return "correct";
        else return "incorrect";
    }


}
