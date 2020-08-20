package com.pillan;

public class Player {


    private String name;
    private long attempts = 0;
    private long score = 0;
    private long storedSips = 0;
    private boolean doubleUp = false;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAttempts() {
        return attempts;
    }

    public void setAttempts(long attempts) {
        this.attempts = attempts;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }


    public long getStoredSips() {
        return storedSips;
    }

    public void setStoredSips(long storedSips) {
        this.storedSips = storedSips;
    }

    public boolean isDoubleUp() {
        return doubleUp;
    }

    public void setDoubleUp(boolean doubleUp) {
        this.doubleUp = doubleUp;
    }
}
