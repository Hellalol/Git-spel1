package com.pillan;

import java.util.List;
import java.util.Random;

public class Game {

    Random r = new Random();
    private Player currentPlayer;
    private int currentPlayerIndex = 0;
    private int number2;
    private int number1;
    private List<Player> playerList;

    public Game(PlayerList playerList) {
        renewNumbers();
        this.playerList = playerList.getPlayerList();
        this.currentPlayer = playerList.getPlayerList().get(currentPlayerIndex);
    }

    public int getNumber2() {
        return number2;
    }

    public int getNumber1() {
        return number1;
    }

    public void renewNumbers(){
        number2 = r.nextInt((100)+1);
        number1 = r.nextInt((100)+1);
    }


    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayerToIndex(){
        currentPlayer = playerList.get(currentPlayerIndex);
    }


    public String guess(boolean over) {
        String toReturn;

        if(number1 == number2) toReturn = "same";
        else if(over && number1 < number2) {
            toReturn = "correct";
        }
        else if(!over && number1 > number2) {
            toReturn = "correct";
        }
        else {
            toReturn = "incorrect";}

        currentPlayer.setAttempts(currentPlayer.getAttempts() + 1);

        if(currentPlayerIndex + 1 > playerList.size() - 1)
            currentPlayerIndex = 0 ;
        else
            currentPlayerIndex++;

        setCurrentPlayerToIndex();
        return toReturn;
    }


}
