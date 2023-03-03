package org.example.phrase.service;

import org.example.phrase.entity.Phrase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PhraseService {


    private long lastPhraseId;
    private final List<Phrase> phrases;

    public PhraseService() {
        lastPhraseId = 0;
        phrases = new ArrayList<>();
    }

    public Phrase findById(long id) {
        for (Phrase phrase : phrases) {
            if (phrase.getId() == id) {
                return phrase;
            }
        }
        return null;
    }

    public List<Phrase> findAll() {
        return phrases;
    }

    public long write(String content, String authorName) throws IOException {
        long id = lastPhraseId + 1;

        Phrase phrase = new Phrase(id, content, authorName);
        phrases.add(phrase);

        lastPhraseId = id; // 증가
        return id;
    }


    public void remove(Phrase phrase) {
        phrases.remove(phrase);
    }

    public void modify(Phrase phrase, String content, String authorName) throws IOException {
        phrase.setContent(content);
        phrase.setAuthorName(authorName);
    }
}
