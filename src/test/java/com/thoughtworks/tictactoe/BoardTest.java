package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

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
    public void shouldDrawColumnsInBoardWhenDrawColumnCalled() {
        board.drawColumns();

        verify(printStream).println("   |   |   ");
    }

    @Test
    public void shouldDrawFlatLinesWhenDrawFlatsCalled() {
        board.drawFlats();

        verify(printStream).println("------------");
    }

    @Test
    public void shouldDrawBoardWhenDrawBoardCalled() {
        board.drawBoard();

        verify(printStream).println("   |   |   \n------------\n   |   |   \n------------\n   |   |   ");
    }
}
