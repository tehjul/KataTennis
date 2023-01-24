package com.tehjul;

import com.tehjul.game.Tennis;
import com.tehjul.model.Player;
import com.tehjul.model.PlayerScore;

public class Main {
    public static void main(String[] args) {

        Player playerOne = new Player("Julien", new PlayerScore());
        Player playerTwo = new Player("Thibault", new PlayerScore());
        Tennis tennis = new Tennis(playerOne, playerTwo);
        tennis.playMatch();
    }
}