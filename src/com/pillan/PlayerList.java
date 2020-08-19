package com.pillan;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerList {

    private List<Player> playerList = new ArrayList<>();
    Player player;


    public void createPlayers(int amount) {
        for (int i = 0; i < amount; i++) {
            player = new Player("player" + i);
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

    public void shufflePlayers(){
        Collections.shuffle(playerList);
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
