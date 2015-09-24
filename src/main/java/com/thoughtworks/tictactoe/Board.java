package com.thoughtworks.tictactoe;

import java.io.PrintStream;

/**
 * Created by nhelvig on 9/24/15.
 */
public class Board {
    private PrintStream printStream;

    public Board(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void drawColumns() {
        printStream.println("   |   |   ");
    }

    public void drawFlats() {
        printStream.println("------------");
    }

    public void drawBoard() {
        printStream.println("   |   |   \n------------\n   |   |   \n------------\n   |   |   ");
    }
}
