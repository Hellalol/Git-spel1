package com.pillan;

import java.util.List;
import java.util.Random;

public class Game {

    Random r = new Random();
    private Player currentPlayer;
    private int currentPlayerIndex = 0;
    private int answer;
    private int number;
    private List<Player> playerList;

    public Game(PlayerList playerList) {
        renewNumbers();
        this.playerList = playerList.getPlayerList();
        this.currentPlayer = playerList.getPlayerList().get(currentPlayerIndex);
    }

    public int getAnswer() {
        return answer;
    }

    public int getNumber() {
        return number;
    }

    public void renewNumbers(){
        answer = r.nextInt((100)+1);
        number = r.nextInt((100)+1);
    }


    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayerToIndex(){
        currentPlayer = playerList.get(currentPlayerIndex);
    }


    public String guess(boolean over) {
        String toReturn;

        if(answer == number) toReturn = "same";
        else if(over && number < answer) {
            toReturn = "correct";
        }
        else if(!over && number > answer) {
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
