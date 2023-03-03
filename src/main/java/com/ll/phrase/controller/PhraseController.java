package com.ll.phrase.controller;


import com.ll.Container;
import com.ll.Rq;
import com.ll.phrase.entity.Phrase;
import com.ll.phrase.service.PhraseService;

import java.io.IOException;
import java.util.List;

public class PhraseController {
    private final PhraseService phraseService;

    public PhraseController() {
        phraseService = new PhraseService();
    }

    public void write() throws IOException {

        System.out.print("명언 : ");
        String content = Container.getBufferedReader().readLine();
        System.out.print("작가 : ");
        String authorName = Container.getBufferedReader().readLine();

        long id = phraseService.write(content, authorName);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    public void list() {
        List<Phrase> phrases = phraseService.findAll();

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(30));

        for (int i = phrases.size() - 1; i >= 0; i--) {
            Phrase phrase = phrases.get(i);

            System.out.printf("%d / %s / %s\n", phrase.getId(), phrase.getAuthorName(), phrase.getContent());
        }
    }

    public void remove(Rq rq) {
        long id = rq.getLongParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

        // 입력된 id와 일치하는 명언객체 찾기
        Phrase phrase = phraseService.findById(id);

        if (phrase == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        // 찾은 명언객체를 리스트에서 제거
        phraseService.remove(phrase);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    public void modify(Rq rq) throws IOException {
        long id = rq.getLongParam("id", -1);

        if (id == -1) {
            System.out.println("id(정수)를 입력해주세요.");
            return;
        }

        // 입력된 id와 일치하는 명언객체 찾기
        Phrase phrase = phraseService.findById(id);

        if (phrase == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("명언(기존) : %s\n", phrase.getContent());
        System.out.print("명언 : ");
        String content = Container.getBufferedReader().readLine();

        System.out.printf("작가(기존) : %s\n", phrase.getAuthorName());
        System.out.print("작가 : ");
        String authorName = Container.getBufferedReader().readLine();

        phraseService.modify(phrase,content,authorName);

        System.out.printf("%d번 명언이 수정되었습니다.\n", id);
    }
}