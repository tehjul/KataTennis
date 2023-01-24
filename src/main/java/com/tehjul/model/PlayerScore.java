package com.tehjul.model;

public class PlayerScore {

    private int gameScore;
    private int matchScore;

    public PlayerScore() {}

    public int getGameScore() {
        return gameScore;
    }

    private void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    public void incrementGameScore() {
        this.gameScore++;
    }

    public void decrementGameScore() throws IllegalAccessException {
        if (this.gameScore <= 0) throw new IllegalAccessException("can't decrement below zero.");
        this.gameScore--;
    }

    public void clearGameScore() {
        this.setGameScore(0);
    }

    public int getMatchScore() {
        return this.matchScore;
    }

    public void incrementMatchScore() {
        this.matchScore++;
    }

}
