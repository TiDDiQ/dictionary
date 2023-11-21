package oop21.dictionaryinterface;

import java.util.Scanner;

public class DictionaryManagement extends Dictionary {
    public DictionaryManagement(int size) {
        super(size);
    }

    public void insertFromCommandline()

    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert number: ");
        int numberOfWord = scanner.nextInt();

        for (int i = 0; i < numberOfWord; i++) {
            System.out.println("Insert English word: ");
            String wordTarget = scanner.nextLine();

            System.out.println("Insert Vietnamese explain: ");
            String wordExplain = scanner.nextLine();

            addWord(new Word(wordTarget, wordExplain));
        }
    }

}