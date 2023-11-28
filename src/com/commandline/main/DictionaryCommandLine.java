package com.commandline.main;

import com.uetoop.main.Tracnghiem;

import java.util.Scanner;

public class DictionaryCommandLine extends DictionaryManagement {
    public void showAllWords() {
        System.out.println("No\t| English\t| Vietnamese");
        for (int i=0; i< getSize(); i++) {
            System.out.println( (i + 1) + "\t| "
                    + getWordList().get(i).getWord_target() + "\t| "
                    + getWordList().get(i).getWord_explain() );
        }
    }

    public void dictionaryBasic() {
        insertFromCommandline();
        showAllWords();
    }

    public void dictionaryAdvanced() {
        System.out.println("Welcome to My Application!\n" +
                "[0] Exit\n" +
                "[1] Add\n" +
                "[2] Remove\n" +
                "[3] Update\n" +
                "[4] Display\n" +
                "[5] Lookup\n" +
                "[6] Search\n" +
                "[7] Game\n" +
                "[8] Import from file\n" +
                "[9] Export from file\n"
        );
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("Your action:");
            int command = scanner.nextInt();
            String dump = scanner.nextLine();
            switch (command) {
                case 0:
                    System.out.println("Goodbye!");
                    loop = false;
                    break;
                case 1:
                    addDictionaryWord();
                    break;
                case 2:
                    removeDictionaryWord();
                    break;
                case 3:
                    updateDictionaryWord();
                    break;
                case 4:
                    showAllWords();
                    break;
                case 5:
                    dictionaryLookup();
                    break;
                case 6:
                    dictionarySearcher();
                    break;
                case 7:
                    Tracnghiem game = new Tracnghiem();
                    game.startGame();
                    break;
                case 8:
                    insertFromFile();
                    break;
                case 9:
                    dictionaryExportToFile();
                    break;
                default:
                    System.out.println("Action not supported");
            }
        }
    }
}

