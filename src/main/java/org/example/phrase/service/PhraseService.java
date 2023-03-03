package org.example.phrase.service;

import org.example.phrase.entity.Phrase;
import org.example.phrase.repository.PhraseRepository;

import java.util.List;

public class PhraseService {

    private final PhraseRepository phraseRepository;

    public PhraseService() {
        phraseRepository = new PhraseRepository();
    }

    public Phrase findById(long id) {
        return phraseRepository.findById(id);
    }

    public List<Phrase> findAll() {
        return phraseRepository.findAll();
    }

    public long write(String content, String authorName) {
        return phraseRepository.write(content, authorName);
    }


    public void remove(Phrase phrase) {
        phraseRepository.remove(phrase);
    }

    public void modify(Phrase phrase, String content, String authorName) {
        phraseRepository.modify(phrase, content, authorName);
    }
}
