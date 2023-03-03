package com.ll.phrase.repository;

import com.ll.phrase.entity.Phrase;
import com.ll.phrase.table.PhraseTable;

import java.util.List;

public class PhraseRepository {

    private final PhraseTable phraseTable;

    public PhraseRepository() {
        phraseTable = new PhraseTable();
    }

    public List<Phrase> findAll() {
        return phraseTable.findAll();
    }

    public Phrase findById(long id) {
        return phraseTable.findById(id);
    }

    public long write(String content, String authorName) {

        long id = phraseTable.getLastId() + 1;

        Phrase phrase = new Phrase(id, content, authorName);
        return phraseTable.save(phrase);
    }

    public void remove(Phrase phrase) {
        phraseTable.remove(phrase);
    }

    public void modify(Phrase phrase, String content, String authorName) {
        phraseTable.modify(phrase, content, authorName);
    }
}
