package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nhelvig on 9/24/15.
 */
public class GameTest {

    Game game;
    PrintStream printStream;
    private NicksBufferedReader reader;
    private Board board;

    @Before
    public void setup() {
        reader = mock(NicksBufferedReader.class);
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        game = new Game(printStream, reader, board);
    }

    @Test
    public void shouldTellTheBoardToDrawAfterGettingAGuess() {
        when(reader.readLine()).thenReturn("1");

        game.nextMove();

        verify(board).drawMove("1");
    }

}
