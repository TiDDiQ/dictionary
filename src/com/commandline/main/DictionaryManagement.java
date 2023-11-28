package com.commandline.main;

import java.io.*;
import java.util.Collections;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {
    Scanner scanner = new Scanner(System.in);

    public void insertFromCommandline() {
        System.out.println("Insert number of words: ");
        int numberOfWord = scanner.nextInt();
        String dump = scanner.nextLine();
        for (int i = 0; i < numberOfWord; i++) {
            System.out.println("Insert English word: ");
            String wordTarget = scanner.nextLine();

            System.out.println("Insert Vietnamese explain: ");
            String wordExplain = scanner.nextLine();

            addWord(new Word(wordTarget, wordExplain));
            System.out.println("Word " + (i+1) + " inserted!");
        }
        Collections.sort(getWordList());
    }

    public void insertFromFile() {
        Scanner scanner;
        try {
            scanner = new Scanner( new File("src/com/commandline/main/dictionaries.txt"), "UTF-8" );
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String text = scanner.useDelimiter("\\A").next();
        scanner.close();
        String[] wordPairs = text.split("\n");
        for (String i : wordPairs) {
            String[] words = i.split("\t");
            addWord(new Word(words[0], words[1]));
        }
        System.out.println("Inserted words from file!");
        Collections.sort(getWordList());
    }

    public void dictionaryExportToFile() {
        System.out.println("Exporting to file....");
        String getDictionaryFile = "";
        for (int i=0; i < getSize(); i++) {
            getDictionaryFile += getWordList().get(i).getWord_target()
                    + "\t" + getWordList().get(i).getWord_explain() + "\n";
        }
        try {
            PrintWriter out = new PrintWriter("src/com/commandline/main/dictionaryExport.txt");
            out.println(getDictionaryFile);
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Export completed!");
    }

    public void dictionaryLookup() {
        System.out.println("Type in a word:");
        String word = scanner.nextLine();
        int index = Collections.binarySearch(getWordList(), new Word(word));
        if (index >= 0) {
            Word foundWord = getWordList().get(index);
            System.out.println("No\t| English\t| Vietnamese");
            System.out.println("1" + "\t| " + word + "\t| " + foundWord.getWord_explain());
        } else {
            System.out.println("No word found");
        }
    }

    public void addDictionaryWord() {
        System.out.println("Insert English word:");
        String wordTarget = scanner.nextLine();
        System.out.println("Insert Vietnamese word:");
        String wordExplain = scanner.nextLine();
        addWord(new Word(wordTarget, wordExplain));
        System.out.println("Word added!");
        Collections.sort(getWordList());
    }

    public void updateDictionaryWord() {
        System.out.println("Select English word:");
        String wordTarget = scanner.nextLine();
        System.out.println("Insert your update:");
        String newWordExplain = scanner.nextLine();
        boolean isFoundWord = false;
        for (Word i : getWordList()) {
            if (i.getWord_target().equals(wordTarget)) {
                isFoundWord = true;
                i.setWord_explain(newWordExplain);
                System.out.println("Word updated");
                break;
            }
        }
        if (!isFoundWord) {
            System.out.println("Word not found");
        }
    }

    public void removeDictionaryWord() {
        System.out.println("Select word to remove:");
        String wordTarget = scanner.nextLine();
        boolean isFoundWord = false;
        for (Word i : getWordList()) {
            if (i.getWord_target().equals(wordTarget)) {
                isFoundWord = true;
                getWordList().remove(i);
                System.out.println("Word removed!");
                break;
            }
        }
        if (!isFoundWord) {
            System.out.println("Word not found");
        }
    }

    public void dictionarySearcher() {
        System.out.println("Insert word:");
        String word = scanner.nextLine();
        boolean isFoundWord = false;
        int no = 1;
        System.out.println("No\t| English\t| Vietnamese");
        for (Word i : getWordList()) {
            if (i.getWord_target().indexOf(word) == 0) {
                isFoundWord = true;
                System.out.println(no + "\t| " + i.getWord_target() + "\t| "
                        + i.getWord_explain());
                no++;
            }
        }
        if (!isFoundWord) {
            System.out.println("No word found");
        }
    }
}