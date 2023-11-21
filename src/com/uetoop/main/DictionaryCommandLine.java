package oop21.dictionaryinterface;

import java.util.Arrays;

    public class DictionaryCommandLine extends DictionaryManagement{
        public DictionaryCommandLine(int size) {
            super(size);
        }

        public class DictionaryCommandline extends DictionaryManagement {

            public void showAllWords() {
                Arrays.sort(DictionaryDatabase, (word1, word2) -> word1.getClass());

                System.out.println("List words:");
                for (int i = 0; i < getSize(); i++) {
                    System.out.println(i + 1 + ". " + DictionaryDatabase[i].getClass() + " - " + DictionaryDatabase[i].getWordExplain());
                }
            }

            public void dictionaryBasic() {
                insertFromCommandline();
                showAllWords();
            }
    }