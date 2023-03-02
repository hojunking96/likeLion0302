package org.example.phrase.controller;


import org.example.Container;
import org.example.Rq;
import org.example.phrase.entity.Phrase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PhraseController {
    private long lastPhraseId;
    private final List<Phrase> phrases;

    public PhraseController() {
        lastPhraseId = 0;
        phrases = new ArrayList<>();
    }

    private Phrase findById(int id) {
        for (Phrase phrase : phrases) {
            if (phrase.getId() == id) {
                return phrase;
            }
        }
        return null;
    }

    public void write() throws IOException {
        long id = lastPhraseId + 1;
        System.out.print("명언 : ");
        String content = Container.getBufferedReader().readLine();
        System.out.print("작가 : ");
        String authorName = Container.getBufferedReader().readLine();

        Phrase wiseSaying = new Phrase(id, content, authorName);
        phrases.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
        lastPhraseId = id; // 증가
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30));

        for (int i = phrases.size() - 1; i >= 0; i--) {
            Phrase wiseSaying = phrases.get(i);

            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthorName(), wiseSaying.getContent());
        }
    }

    public void remove(Rq rq) {
        int id = rq.getIntParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

        // 입력된 id와 일치하는 명언객체 찾기
        Phrase wiseSaying = findById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        // 찾은 명언객체를 리스트에서 제거
        phrases.remove(wiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    public void modify(Rq rq) throws IOException {
        int id = rq.getIntParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

        // 입력된 id와 일치하는 명언객체 찾기
        Phrase wiseSaying = findById(id);

        if (wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("명언(기존) : %s\n", wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = Container.getBufferedReader().readLine();

        System.out.printf("작가(기존) : %s\n", wiseSaying.getAuthorName());
        System.out.print("작가 : ");
        String authorName = Container.getBufferedReader().readLine();

        wiseSaying.setContent(content);
        wiseSaying.setAuthorName(authorName);

        System.out.printf("%d번 명언이 수정되었습니다.\n", id);
    }
}