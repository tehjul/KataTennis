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
        this.playerOne.score().clearGameScore();
        this.playerTwo.score().clearGameScore();
    }

    public void printGameScore() {
        System.out.print("Game n°" + ((this.playerOne.score().getMatchScore() + this.playerTwo.score().getMatchScore() + 1) + ", "));
        printGameScoreWithName(this.playerOne.score().getGameScore(), this.playerTwo.score().getGameScore());
    }

    public void printMatchScore() {
        System.out.println();
        System.out.print("Match score : ");
        printScore(this.playerOne.score().getMatchScore(), this.playerTwo.score().getMatchScore());
        System.out.println();
    }

    public void printWinner() {
        int result = this.playerOne.score().getMatchScore() - this.playerTwo.score().getMatchScore();
        Player winner = result > 0 ? this.playerOne : this.playerTwo;
        System.out.println("Game, Set and Match " + winner.name() + " !");
    }

    private void printScore(int playerOneScore, int playerTwoScore) {
        System.out.println(this.playerOne.name() + ": " + playerOneScore + " " + this.playerTwo.name() + ": " + playerTwoScore);
    }

    private void printGameScoreWithName(int playerOneScore, int playerTwoScore) {
        System.out.println(this.playerOne.name() + ": " + MatchPoints.values()[playerOneScore] + " - " + this.playerTwo.name() + ": " + MatchPoints.values()[playerTwoScore]);
    }
}
