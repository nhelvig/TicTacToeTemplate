package com.thoughtworks.tictactoe;

import java.io.PrintStream;

/**
 * Created by nhelvig on 9/24/15.
 */
public class Player {


    private String symbol;
    private String name;
    private PrintStream printStream;
    private NicksBufferedReader reader;


    public Player(String symbol, String name, PrintStream printStream, NicksBufferedReader reader) {
        this.symbol = symbol;
        this.name = name;
        this.printStream = printStream;
        this.reader = reader;
    }

    //Not sure how to avoid these getters

    public String getSymbol() {
        return symbol;
    }

    public String getNextMove() {
        printStream.println("Please enter a position (1-9)");
        String playerMove = reader.readLine();
        return playerMove;
    }

    public String getName() {
       return name;
    }
}
