package com.thoughtworks.tictactoe;

import java.io.PrintStream;

/**
 * Created by nhelvig on 9/24/15.
 */
public class Game {
    private PrintStream printStream;
    private NicksBufferedReader reader;
    private Board board;

    public Game(PrintStream printStream, NicksBufferedReader reader, Board board) {
        this.printStream = printStream;
        this.reader = reader;
        this.board = board;
    }

    public void nextMove() {
        printStream.println("Please enter a position (1-9)");
        String playerMove = reader.readLine();
        board.drawMove(playerMove);
    }

    public void start() {

    }
}
