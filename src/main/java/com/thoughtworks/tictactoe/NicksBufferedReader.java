package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nhelvig on 9/24/15.
 */
public class NicksBufferedReader {

    private BufferedReader bufferedReader;

    public NicksBufferedReader() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeIOException();
        }
    }
}
