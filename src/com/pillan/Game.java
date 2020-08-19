package com.pillan;

import java.util.Random;

public class Game {

    Random r = new Random();
    private Player currentPlayer;
    private int answer;
    private int number;

    public Game(Player currentPlayer) {
        generateAnswer();
        generateNumber();
        this.currentPlayer = currentPlayer;
    }

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


    public String guess(boolean over) {
        currentPlayer.setAttempts(currentPlayer.getAttempts() + 1);

        if(answer == number) return "same";

        else if(over && number > answer) {
            currentPlayer.setScore(currentPlayer.getScore() + 1);
            return "correct";
        }

        else if(!over && number < answer) {
            currentPlayer.setScore(currentPlayer.getScore() + 1);
            return "correct";
        }

        else {
            currentPlayer.setStoredSips(currentPlayer.getStoredSips() + 1);
            return "incorrect";}
    }


}
