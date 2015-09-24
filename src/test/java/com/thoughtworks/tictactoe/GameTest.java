package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by nhelvig on 9/24/15.
 */
public class GameTest {

    Game game;
    PrintStream printStream;
    private NicksBufferedReader reader;

    @Before
    public void setup() {
        reader = mock(NicksBufferedReader.class);
        printStream = mock(PrintStream.class);
        game = new Game(printStream, reader);
    }

    @Test
    public void shouldGetANumberFromThePlayerWhenRequestingNextMove() {
        when(reader.readLine()).thenReturn("6");

        assertEquals(game.getNextMove(), "6");
    }

    @Test
    public void shouldDrawXInTopLeftSpaceWhenUserEntersOne() {

    }

    @Test
    public void shouldDrawXInTopMiddleSpaceWhenUserEntersTwo() {

    }

    @Test
    public void shouldDrawXInTopLeftSpaceWhenUserEntersThree() {

    }

    @Test
    public void shouldDrawXInTopLeftSpaceWhenUserEntersFour() {

    }

    @Test
    public void shouldDrawXInTopLeftSpaceWhenUserEntersFive() {

    }

    @Test
    public void shouldDrawXInTopLeftSpaceWhenUserEntersSix() {

    }

    @Test
    public void shouldDrawXInTopLeftSpaceWhenUserEntersSeven() {

    }

    @Test
    public void shouldDrawXInTopLeftSpaceWhenUserEntersEight() {

    }

    @Test
    public void shouldDrawXInTopLeftSpaceWhenUserEntersNine() {

    }


}
