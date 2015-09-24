package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

/**
 * Created by nhelvig on 9/24/15.
 */
public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private Player player1;
    private Player player2;


    @Before
    public void setup() {
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldDrawBoardWhenDrawBoardCalled() {
        board.drawBoard();

        verify(printStream).println("   |   |   \n------------\n   |   |   \n------------\n   |   |   ");
    }

    @Test
    public void shouldDrawXInTopLeftSpaceWithOne() {
        when(player1.getSymbol()).thenReturn("X");

        board.drawMove("1", player1);

        verify(printStream).println(" X |   |   \n" +
                "------------\n" +
                "   |   |   \n" +
                "------------\n" +
                "   |   |   ");
    }

    @Test
    public void shouldDrawXInBottomRightSpaceWithNine() {
        when(player1.getSymbol()).thenReturn("X");

        board.drawMove("9", player1);

        verify(printStream).println("   |   |   \n" +
                "------------\n" +
                "   |   |   \n" +
                "------------\n" +
                "   |   | X ");
    }

    @Test
    public void shouldDrawXInMiddleSpaceWithFive() {
        when(player1.getSymbol()).thenReturn("X");

        board.drawMove("5", player1);

        verify(printStream).println("   |   |   \n" +
                "------------\n" +
                "   | X |   \n" +
                "------------\n" +
                "   |   |   ");
    }

    @Test
    public void shouldDrawCorrectBoardWithTwoPlayersPickingOneAndThenFive() {
        when(player1.getSymbol()).thenReturn("X");
        when(player2.getSymbol()).thenReturn("O");

        board.drawMove("1", player1);
        board.drawMove("5", player2);

        verify(printStream).println(" X |   |   \n" +
                "------------\n" +
                "   | O |   \n" +
                "------------\n" +
                "   |   |   ");
    }

    @Test
    public void shouldNotAllowPlayerToMakeAMoveOnATakenSpace() {
        when(player1.getSymbol()).thenReturn("X");
        when(player2.getSymbol()).thenReturn("O");

        board.drawMove("5", player1);

        assertEquals(false, board.verifyLegalMove("5"));
    }

    @Test
    public void shouldSayTheBoardIsFullIfItIsFull () {
        board.drawMove("1", player1);
        board.drawMove("2", player1);
        board.drawMove("3", player1);
        board.drawMove("4", player1);
        board.drawMove("5", player1);
        board.drawMove("6", player1);
        board.drawMove("7", player1);
        board.drawMove("8", player1);
        board.drawMove("9", player1);

        assertEquals(true, board.isFull());
    }

    @Test
    public void shouldRecognizeAWinningCombinationWhenThereIsOne() {

    }

}
