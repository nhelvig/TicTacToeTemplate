package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {

        PrintStream printStreamOut = new PrintStream(System.out);
        Board board = new Board(printStreamOut);
        Player player1 = new Player("X", printStreamOut, new NicksBufferedReader());
        Player player2 = new Player("O", printStreamOut, new NicksBufferedReader());
        Game game = new Game(board, player1, player2);
        game.start();
    }
}
