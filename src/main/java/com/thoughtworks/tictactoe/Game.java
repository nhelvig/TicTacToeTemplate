package com.thoughtworks.tictactoe;

import java.io.PrintStream;

/**
 * Created by nhelvig on 9/24/15.
 */
public class Game {
    private PrintStream printStream;
    private NicksBufferedReader reader;

    public Game(PrintStream printStream, NicksBufferedReader reader) {
        this.printStream = printStream;
        this.reader = reader;
    }

    public String getNextMove() {
        printStream.println("Please enter a position (1-9)");
        String playerMove = reader.readLine();
        return playerMove;
    }

    public void start() {

    }
}
