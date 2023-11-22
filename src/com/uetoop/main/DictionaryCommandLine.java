package com.uetoop.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

    public class DictionaryCommandLine extends Tracnghiem {
        public static void main(String[] args) {
            DictionaryCommandLine cmdL = new DictionaryCommandLine();
            System.out.println("Welcome to My Application!\n" +
                    "[0] Exit\n" +
                    "[1] Add\n" +
                    "[2] Remove\n" +
                    "[3] Update\n" +
                    "[4] Display\n" +
                    "[5] Lookup\n" +
                    "[6] Search\n" +
                    "[7] Game\n" +
                    "[8] Export from file\n"
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
                        System.out.println("Enter the word:");
                        String word = scanner.nextLine();
                        System.out.println("Enter its description:");
                        String description = scanner.nextLine();
                        System.out.println("Enter its pronunciation");
                        String pronunciation = scanner.nextLine();
                        cmdL.addDatabase(word, description, pronunciation);
                        System.out.println("Word successfully added!");
                        break;
                    case 2:
                        System.out.println("Word to remove:");
                        word = scanner.nextLine();
                        cmdL.removeDatabaseWord(word);
                        System.out.println("Word successfully removed!");
                        break;
                    case 3:
                        System.out.println("Choose the word you want to update:\n");
                        word = scanner.nextLine();
                        System.out.println("What do you want to update:\n" +
                                    "[1]: word\n" +
                                    "[2]: description\n" +
                                    "[3]: pronunciation"
                                );
                        int subCmd = scanner.nextInt();
                        dump = scanner.nextLine();
                        switch (subCmd) {
                            case 1:
                                System.out.println("Enter your word update: ");
                                String update = scanner.nextLine();
                                cmdL.updateWord(word, update, "word");
                                System.out.println("Successfully updated");
                                break;
                            case 2:
                                System.out.println("Enter your description update: ");
                                update = scanner.nextLine();
                                cmdL.updateWord(word, update, "description");
                                System.out.println("Successfully updated");
                                break;
                            case 3:
                                System.out.println("Enter your pronunciation update: ");
                                update = scanner.nextLine();
                                cmdL.updateWord(word, update, "pronounce");
                                System.out.println("Successfully updated");
                                break;
                            default:
                                System.out.println("Error");
                        }
                        break;
                    case 4:
                        System.out.println("How do you want to display:\n" +
                                "[1]: Dictionary\n" +
                                "[2]: Favourite words\n" +
                                "[3]: By alphabet"
                        );
                        subCmd = scanner.nextInt();
                        dump = scanner.nextLine();
                        System.out.println("Choose page:");
                        int page = scanner.nextInt();
                        dump = scanner.nextLine();
                        switch (subCmd) {
                            case 1:
                                System.out.println(cmdL.showDatabasePage(page));
                                break;
                            case 2:
                                System.out.println(cmdL.showDatabaseFavouritePage(page));
                                break;
                            case 3:
                                System.out.println("Choose character:");
                                char alphabet = scanner.next().charAt(0);
                                System.out.println(cmdL.showDatabaseAlphabetPage(alphabet, page));
                                break;
                            default:
                                System.out.println("Error");
                        }
                        break;
                    case 5:
                        System.out.println("Choose word:");
                        word = scanner.nextLine();
                        String word5 = cmdL.findWord("word", word);
                        if (!word5.equals("")) {
                            try {
                                System.out.println("Translation:\t" + cmdL.translate(word));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("Meaning:\t" + cmdL.findDescription(word));
                        } else {
                            System.out.println("Word not found");
                        }
                        break;
                    case 6:
                        System.out.println("Input word:");
                        word = scanner.nextLine();
                        System.out.println("Choose page:");
                        page = scanner.nextInt();
                        dump = scanner.nextLine();
                        String lookup = cmdL.showDatabaseLookalikeWordPage(word, page);
                        if(!lookup.equals("")){
                            System.out.println(lookup);
                        } else {
                            System.out.println("No match cases found");
                        }
                        break;
                    case 7:
                        cmdL.game();
                        break;
                    case 8:
                        System.out.println("How many pages?:");
                        int n = scanner.nextInt();
                        dump = scanner.nextLine();
                        System.out.println("Exporting...");
                        try {
                            PrintWriter out = new PrintWriter("filename.txt");
                            int i = 1;
                            while (i <= n) {
                                out.println(cmdL.showDatabasePage(i));
                                System.out.println("Page " + i + " complete");
                                i++;
                            }
                            out.close();
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println("Export completed!");
                        break;
                    default:
                        System.out.println("Error");
                }
            }

        }

    }


