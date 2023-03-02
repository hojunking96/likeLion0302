package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Container {
    private static BufferedReader br;

    public static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void close() throws IOException {
        br.close();
    }

    public static BufferedReader getBufferedReader() {
        return br;
    }
}