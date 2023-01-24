package com.tehjul.model;

import com.tehjul.enums.MatchPoints;

public class MatchScore {

    private final Player playerOne;
    private final Player playerTwo;

    public MatchScore(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void clearGameScores() {
        playerOne.score().clearGameScore();
        playerTwo.score().clearGameScore();
    }

    public void printGameScore() {
        System.out.print("Game n°" + ((playerOne.score().getMatchScore() + playerTwo.score().getMatchScore() + 1) + ", "));
        printGameScoreWithName(playerOne.score().getGameScore(), playerTwo.score().getGameScore());
    }

    public void printMatchScore() {
        System.out.println();
        System.out.print("Match score : ");
        printScore(playerOne.score().getMatchScore(), playerTwo.score().getMatchScore());
        System.out.println();
    }

    private void printScore(int playerOneScore, int playerTwoScore) {
        System.out.println(playerOne.name() + ": " + playerOneScore + " " + playerTwo.name() + ": " + playerTwoScore);
    }

    private void printGameScoreWithName(int playerOneScore, int playerTwoScore) {
        System.out.println(playerOne.name() + ": " + MatchPoints.values()[playerOneScore] + " - " + playerTwo.name() + ": " + MatchPoints.values()[playerTwoScore]);
    }
}
