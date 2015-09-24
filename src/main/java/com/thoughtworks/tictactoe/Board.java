package com.thoughtworks.tictactoe;

import java.io.PrintStream;

/**
 * Created by nhelvig on 9/24/15.
 */
public class Board {
    private  String currentBoard;
    private PrintStream printStream;

    public Board(PrintStream printStream) {
        this.currentBoard = "   |   |   \n------------\n   |   |   \n------------\n   |   |   ";
        this.printStream = printStream;
    }


    public void drawBoard() {
        printStream.println(currentBoard);
    }

    public void drawMove(String s) {
        int positionOnBoard = Integer.parseInt(s);
        int positionInCurrentBoard = 0;
        positionInCurrentBoard = getPositionInCurrentBoard(positionOnBoard, positionInCurrentBoard);
        this.currentBoard = this.currentBoard.substring(0, positionInCurrentBoard) + "X" + this.currentBoard.substring(positionInCurrentBoard + 1, this.currentBoard.length());
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
}
