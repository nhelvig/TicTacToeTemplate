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
    private PrintStream printStream;

    public Game(Board board, Player player1, Player player2, PrintStream printStream) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.printStream = printStream;
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
                switchCurrentPlayer();
            }
        }
        printStream.println("The game is a draw!");
    }

    public void switchCurrentPlayer() {
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }
}
