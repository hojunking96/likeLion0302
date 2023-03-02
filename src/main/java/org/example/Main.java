package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("== 명언 앱 ==");
        System.out.print("명령) ");
        while (true) {
            String input = br.readLine();
            if (input.equals("종료")) {
                break;
            }
        }
    }
}