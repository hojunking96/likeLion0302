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

                List<Integer> keyList = new ArrayList<>(phrases.keySet());
                keyList.sort((s1, s2) -> s2 - s1);
                for (int key : keyList) {
                    System.out.println(key + " / " + phrases.get(key).getWriter() + " / " + phrases.get(key).getSentence());
                }
            } else if (func.substring(0, 2).equals("삭제")) {
                int deleteID = Integer.parseInt(func.substring(6));
                if (phrases.containsKey(deleteID)) {
                    phrases.remove(deleteID);
                    System.out.println(deleteID + "번 명언이 삭제되었습니다.");
                } else {
                    System.out.println(deleteID + "번 명언은 존재하지 않습니다.");
                }
            } else if (func.substring(0, 2).equals("수정")) {
                int modifyID = Integer.parseInt(func.substring(6));
                System.out.println("명언(기존) : " + phrases.get(modifyID).getSentence());
                System.out.print("명언 : ");
                String sentence = br.readLine();
                System.out.println("작가(기존) : " + phrases.get(modifyID).getWriter());
                System.out.print("작가 : ");
                String writer = br.readLine();
                phrases.put(modifyID, new Phrase(writer, sentence));
            }
        }

    }
}