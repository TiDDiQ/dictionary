package com.uetoop.main;

import java.util.Arrays;

    public class DictionaryCommandLine extends Dictionary {
        public DictionaryCommandLine(int size) {
            super(size);
        }

        public class DictionaryCommandline extends Dictionary {

            public DictionaryCommandline(int size) {
                super(size);
            }

            public void showAllWords() {
                Arrays.sort(wordList, (word1, word2) -> word1.getClass().getModifiers());

                System.out.println("List words:");
                for (int i = 0; i < getSize(); i++) {
                    System.out.println(i + 1 + ". " + wordList[i].getClass() + " - " + wordList[i].getWordExplain());
                }
            }

            public void dictionaryBasic() {
                insertFromCommandline();
                showAllWords();
            }

            private void insertFromCommandline() {

            }
        }
    }