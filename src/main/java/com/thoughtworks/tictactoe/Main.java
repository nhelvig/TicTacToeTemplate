package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {

        PrintStream printStreamOut = new PrintStream(System.out);
        Board board = new Board(printStreamOut);
        Game game = new Game(printStreamOut, new NicksBufferedReader(), board);
        game.start();
    }
}
