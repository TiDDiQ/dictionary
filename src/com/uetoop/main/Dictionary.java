package com.uetoop.main;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
        private List<Word> wordList = new ArrayList<>();

        public Dictionary() {
        }

        public void addWord(Word word) {
            for (Word i : wordList) {
                if (i.equals(word)) {
                    return;
                }
            }
            wordList.add(word);
        }

        public int getSize() {
            return wordList.size();
        }

        public List<Word> getWordList() {
            return wordList;
        }
}
