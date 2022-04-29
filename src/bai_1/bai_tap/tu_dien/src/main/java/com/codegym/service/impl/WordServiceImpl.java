package com.codegym.service.impl;

import com.codegym.model.Word;
import com.codegym.service.IWordService;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;
@Service
public class WordServiceImpl implements IWordService {
   private static List<Word> dictionary;

   static {
       Word word1 = new Word("hello","xin chào");
       Word word2 = new Word("spring","mùa xuân");
       Word word3 = new Word("love","tình yêu");
       Word word4 = new Word("beach","biển");
       dictionary.add(word1);
       dictionary.add(word2);
       dictionary.add(word3);
       dictionary.add(word4);
   }
    @Override
    public Word findWord(String word) {
       Word wordFounded = null;
        for (Word w: dictionary
             ) {
            if(w.getWord().equals(word)) {
               wordFounded = w;
            }
        }
        return wordFounded;
    }
}
