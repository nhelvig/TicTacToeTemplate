package com.thoughtworks.tictactoe;

import java.io.PrintStream;

/**
 * Created by nhelvig on 9/24/15.
 */
public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void start() {
        currentPlayer = player1;
        nextMove();

    }

    private void nextMove() {

        while (!board.isFull()) {
            String move = currentPlayer.getNextMove();
            if (board.verifyLegalMove(move)) {
                board.drawMove(move, currentPlayer);
                switchPlayers();
            }
        }
    }

    public void switchPlayers() {
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
}
