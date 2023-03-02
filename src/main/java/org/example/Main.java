package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static class Phrase {
        private String writer;
        private String sentence;

        public Phrase(String writer, String sentence) {
            this.writer = writer;
            this.sentence = sentence;
        }

        public String getWriter() {
            return writer;
        }

        public String getSentence() {
            return sentence;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Phrase> phrases = new HashMap<>();

        System.out.println("== 명언 앱 ==");
        int phraseCnt = 0;
        while (true) {
            System.out.print("명령) ");
            String func = br.readLine();
            if (func.equals("종료")) {
                break;
            } else if (func.equals("등록")) {
                phraseCnt++;
                System.out.print("명언 : ");
                String sentence = br.readLine();

                System.out.print("작가 : ");
                String writer = br.readLine();

                phrases.put(phraseCnt, new Phrase(writer, sentence));
                System.out.println(phraseCnt + "번 명언이 등록되었습니다.");
            } else if (func.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for (int i = phrases.size(); i >= 1; i--) {
                    Phrase phrase = phrases.get(i);
                    System.out.println(i + " / " + phrase.getWriter() + " / " + phrase.getSentence());
                }
            } else if (func.substring(0, 2).equals("삭제")) {
                int deleteID = Integer.parseInt(func.substring(6));
                if (phrases.containsKey(deleteID)) {
                    phrases.remove(deleteID);
                    System.out.println(deleteID + "번 명언이 삭제되었습니다.");
                } else {
                    System.out.println(deleteID + "번 명언은 존재하지 않습니다.");
                }
            }
        }


    }
}