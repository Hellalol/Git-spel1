package com.pillan;


import java.util.ArrayList;
import java.util.List;

public class PlayerList {

    private List<Player> playerList = new ArrayList<>();
    Player player;


    public void createPlayers(int amount) {
        for (int i = 0; i < amount; i++) {
            player = new Player("temp" + i);
            playerList.add(player);
        }
    }

    public Player findPlayer(String name) {
        for (Player player : playerList) {
            if (name.equals(player.getName())) {
                return player;
            }

        }
        return null;
    }
}
