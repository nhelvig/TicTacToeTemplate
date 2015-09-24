package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

/**
 * Created by nhelvig on 9/24/15.
 */
public class BoardTest {

    PrintStream printStream;
    Board board;

    @Before
    public void setup() {
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
        board.drawMove("1");

        verify(printStream).println(" X |   |   \n" +
                "------------\n" +
                "   |   |   \n" +
                "------------\n" +
                "   |   |   ");
    }

    @Test
    public void shouldDrawXInBottomRightSpaceWithNine() {
        board.drawMove("9");

        verify(printStream).println("   |   |   \n" +
                "------------\n" +
                "   |   |   \n" +
                "------------\n" +
                "   |   | X ");
    }

    @Test
    public void shouldDrawXInMiddleSpaceWithFive() {
        board.drawMove("5");

        verify(printStream).println("   |   |   \n" +
                "------------\n" +
                "   | X |   \n" +
                "------------\n" +
                "   |   |   ");
    }


}
