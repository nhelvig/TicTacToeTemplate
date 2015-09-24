package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Created by nhelvig on 9/24/15.
 */
public class Board {
    private  String currentBoard;
    private PrintStream printStream;
    private boolean[] positionTaken;

    public Board(PrintStream printStream) {
        this.currentBoard = "   |   |   \n------------\n   |   |   \n------------\n   |   |   ";
        this.printStream = printStream;
        this.positionTaken = new boolean[9];
    }


    public void drawBoard() {
        printStream.println(currentBoard);
    }

    public void drawMove(String s, Player player1) {
        int positionOnBoard = Integer.parseInt(s);
        positionTaken[positionOnBoard - 1] = true;
        int positionInCurrentBoard = 0;
        positionInCurrentBoard = getPositionInCurrentBoard(positionOnBoard, positionInCurrentBoard);
        this.currentBoard = this.currentBoard.substring(0, positionInCurrentBoard) + player1.getSymbol() + this.currentBoard.substring(positionInCurrentBoard + 1, this.currentBoard.length());
        drawBoard();
    }

    private int getPositionInCurrentBoard(int positionOnBoard, int positionInCurrentBoard) {
        if (positionOnBoard <= 3) {
            positionInCurrentBoard = ((positionOnBoard - 1) * 4) + 1;
        } else if (positionOnBoard <= 6 ) {
            positionInCurrentBoard = ((positionOnBoard - 4) * 4) + 26;
        } else if (positionOnBoard <= 9 ) {
            positionInCurrentBoard = ((positionOnBoard - 7) * 4) + 51;
        }
        return positionInCurrentBoard;
    }

    public boolean verifyLegalMove(String s) {
        int move = Integer.parseInt(s) - 1;
        if (positionTaken[move]) {
            printStream.println("Location already taken. Please try again.");
            return false;
        }
        return true;
    }

    public boolean isFull() {
        for (boolean spotTaken : positionTaken) {
            if (!spotTaken) {
                return false;
            }
        }
        return true;
    }
}
