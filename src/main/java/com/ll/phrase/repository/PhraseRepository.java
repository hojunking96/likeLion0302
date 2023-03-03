package com.ll.phrase.repository;

import com.ll.phrase.entity.Phrase;

import java.util.ArrayList;
import java.util.List;

public class PhraseRepository {

    private long lastPhraseId;
    private final List<Phrase> phrases;

    public PhraseRepository() {
        lastPhraseId = 0;
        phrases = new ArrayList<>();
    }

    public List<Phrase> findAll() {
        return phrases;
    }

    public Phrase findById(long id) {
        for (Phrase phrase : phrases) {
            if (phrase.getId() == id) {
                return phrase;
            }
        }
        return null;
    }

    public long write(String content, String authorName) {

        long id = lastPhraseId + 1;

        Phrase phrase = new Phrase(id, content, authorName);
        phrases.add(phrase);

        lastPhraseId = id; // 증가
        return id;
    }

    public void remove(Phrase phrase) {
        phrases.remove(phrase);
    }

    public void modify(Phrase phrase, String content, String authorName) {
        phrase.setContent(content);
        phrase.setAuthorName(authorName);
    }
}
