package com.pillan;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerList {

    private List<Player> playerList = new ArrayList<>();
    Player player;


    public List<Player> createPlayers(List<String> playerNameList) {
        for (String name : playerNameList) {
            player = new Player(name);
            playerList.add(player);
        }
        return playerList;
    }

    public Player findPlayer(String name) {
        for (Player player : playerList) {
            if (name.equals(player.getName())) {
                return player;
            }

        }
        return null;
    }

    public void shufflePlayers() {
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
