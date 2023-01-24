package com.tehjul.game;

import com.tehjul.enums.MatchPoints;
import com.tehjul.enums.MatchStatus;
import com.tehjul.interfaces.TennisGame;
import com.tehjul.model.Player;
import com.tehjul.model.MatchScore;

import static com.tehjul.helpers.MathHelpers.getRandom;
import static com.tehjul.helpers.MathHelpers.hasDifferenceOfTwo;

public class Tennis implements TennisGame {
    private final int ADVANTAGE = MatchPoints.ADVANTAGE.ordinal();
    private final int WINNING_POINT = ADVANTAGE + 1;
    private MatchStatus matchStatus;
    private final MatchScore matchScore;
    private final Player playerOne;
    private final Player playerTwo;

    public Tennis(Player playerOne, Player playerTwo) {
        this.matchStatus = MatchStatus.PLAYING;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.matchScore = new MatchScore(playerOne, playerTwo);
    }

    @Override
    public void playMatch() {
        while (!isMatchOver()) playGame();
        this.matchScore.printWinner();
    }

    @Override
    public void playGame() {
        while (!isGameOver()) playPoint();
    }

    @Override
    public void playPoint() {
        int rand = getRandom();
        this.evaluatePoint(rand);
        if (isGameOver()) {
            checkIfMatchIsOver();
            if (!isMatchOver()) {
                this.matchScore.clearGameScores();
            }
            this.matchScore.printMatchScore();
        } else this.matchScore.printGameScore();
    }

    private void evaluatePoint(int pointWinner) {
        switch (pointWinner) {
            case 1 -> evaluateWinner(this.playerOne);
            case 2 -> evaluateWinner(this.playerTwo);
            default -> throw new IllegalArgumentException("Number must be 1 or 2");
        }
    }

    private void evaluateWinner(Player winner) {
        Player loser = (winner == this.playerOne) ? this.playerTwo : this.playerOne;
        int loserScore = loser.score().getGameScore();

        if (loserScore == ADVANTAGE) {
            try {
                loser.score().decrementGameScore();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } else winner.score().incrementGameScore();

        int winnerScore = winner.score().getGameScore();
        if (winnerScore == ADVANTAGE && hasTwoPointsAhead() || winnerScore == WINNING_POINT)
            winner.score().incrementMatchScore();
    }

    private void checkIfMatchIsOver() {
        if (playerOneHasWonMatch() || playerTwoHasWonMatch())
            this.matchStatus = MatchStatus.OVER;
    }

    private boolean playerOneHasWonMatch() {
        return playerHasWonMatch(this.playerOne);
    }

    private boolean playerTwoHasWonMatch() {
        return playerHasWonMatch(this.playerTwo);
    }

    private boolean playerHasWonMatch(Player player) {
        int WINNING_SET = 6;
        int WINNING_SET_TIEBREAK = 7;
        return player.score().getMatchScore() >= WINNING_SET && hasTwoGamesAhead() || player.score().getMatchScore() == WINNING_SET_TIEBREAK;
    }

    private boolean isGameOver() {
        return this.playerOne.score().getGameScore() >= ADVANTAGE && hasTwoPointsAhead() || this.playerTwo.score().getGameScore() >= ADVANTAGE && hasTwoPointsAhead();
    }

    private boolean isMatchOver() {
        return this.matchStatus == MatchStatus.OVER;
    }

    private boolean hasTwoPointsAhead() {
        return hasTwoMore(this.playerOne.score().getGameScore(), this.playerTwo.score().getGameScore());
    }

    private boolean hasTwoGamesAhead() {
        return hasTwoMore(this.playerOne.score().getMatchScore(), this.playerTwo.score().getMatchScore());
    }

    private boolean hasTwoMore(int p1Score, int p2Score) {
        return hasDifferenceOfTwo(p1Score, p2Score);
    }

}
