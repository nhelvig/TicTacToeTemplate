package com.thoughtworks.tictactoe;

import java.io.PrintStream;

/**
 * Created by nhelvig on 9/24/15.
 */
public class Player {


    private String symbol;
    private PrintStream printStream;
    private NicksBufferedReader reader;


    public Player(String symbol, PrintStream printStream, NicksBufferedReader reader) {
        this.symbol = symbol;
        this.printStream = printStream;
        this.reader = reader;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getNextMove() {
        printStream.println("Please enter a position (1-9)");
        String playerMove = reader.readLine();
        return playerMove;
    }
}
