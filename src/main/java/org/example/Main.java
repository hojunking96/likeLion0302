package org.example;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Container.init();
        new App().run();
        Container.close();
    }
}