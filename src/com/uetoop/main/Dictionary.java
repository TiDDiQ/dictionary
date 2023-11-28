package com.uetoop.main;

public class Dictionary {
        public Word[] wordList;
        private int size;

        public Dictionary(int size) {
            this.wordList = new Word[size];
            this.size = 0;
        }

        public void addWord(Word word) {
            if (size == wordList.length) {
                expandWordList();
            }
            wordList[size++] = word;
        }

        private void expandWordList() {
            Word[] newWordList = new Word[wordList.length * 2];
            for (int i = 0; i < size; i++) {
                newWordList[i] = wordList[i];
            }
            wordList = newWordList;
        }

        public Word getWord(String word_target) {
            for (int i = 0; i < size; i++) {
                if (wordList[i].getWordTarget()) {
                    return wordList[i];
                }
            }
            return null;
        }

        public int getSize() {
            return size;
        }

    }
