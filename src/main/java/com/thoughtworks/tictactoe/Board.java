package com.thoughtworks.tictactoe;

import java.io.PrintStream;

/**
 * Created by nhelvig on 9/24/15.
 */
public class Board {
    private  int[][] winningCombinations = new int[8][3];
    private  String currentBoard;
    private PrintStream printStream;
    private Player[] playerPosition;

    public Board(PrintStream printStream) {
        this.currentBoard = "   |   |   \n------------\n   |   |   \n------------\n   |   |   ";
        this.printStream = printStream;
        this.playerPosition = new Player[9];
        this.winningCombinations = new int[][]{
                {0,1,2},
                {3,4,5},
                {6,7,8},
                {0,3,6},
                {1,4,7},
                {2,5,8},
                {0,4,8},
                {2,4,6}};
    }


    public void drawBoard() {
        printStream.println(currentBoard);
    }

    public void drawMove(String s, Player player) {
        int positionOnBoard = Integer.parseInt(s);
        playerPosition[positionOnBoard - 1] = player;
        int positionInCurrentBoard = 0;
        positionInCurrentBoard = getPositionInCurrentBoard(positionOnBoard, positionInCurrentBoard);
        this.currentBoard = this.currentBoard.substring(0, positionInCurrentBoard) + player.getSymbol() + this.currentBoard.substring(positionInCurrentBoard + 1, this.currentBoard.length());
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
        if (playerPosition[move] != null) {
            printStream.println("Location already taken. Please try again.");
            return false;
        }
        return true;
    }

    public boolean isFull() {
        for (Player player : playerPosition) {
            if (player == null) {
                return false;
            }
        }
        return true;
    }

    public boolean hasWinningCombination() {
        for (int[] combination : winningCombinations) {
            Player firstSpace = playerPosition[combination[0]];
            Player secondSpace = playerPosition[combination[1]];
            Player thirdSpace = playerPosition[combination[2]];
            if (firstSpace != null && secondSpace != null && thirdSpace != null) {
                if (firstSpace.equals(secondSpace) && secondSpace.equals(thirdSpace)) {
                    return true;
                }
            }
        }
        return false;
    }
}
