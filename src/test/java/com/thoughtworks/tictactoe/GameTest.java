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

    private Game game;
    private PrintStream printStream;
    private NicksBufferedReader reader;
    private Board board;
    private Player player1;
    private Player player2;


    @Before
    public void setup() {
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        reader = mock(NicksBufferedReader.class);
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        game = new Game(board, player1, player2, printStream);
    }

    @Test
    public void shouldTellTheBoardToDrawAfterGettingAGuess() {
        when(player1.getNextMove()).thenReturn("1");
        when(board.isFull()).thenReturn(false, true);
        when(board.verifyLegalMove("1")).thenReturn(true);

        game.start();

        verify(board).drawMove("1", player1);
    }

    @Test
    public void shouldSayTheGameIsADrawWhenTheBoardIsFull() {
        when(board.isFull()).thenReturn(true);

        game.start();

        verify(printStream).println("The game is a draw!");
    }


}
