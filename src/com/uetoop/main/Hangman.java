package com.uetoop.main;
import java.util.Scanner;
import java.util.Random;

public class Hangman {

    public static void main(String[] args) {
        DictionaryDatabase db = new DictionaryDatabase();
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            Random obj = new Random();
            int Ran_num = obj.nextInt(108854);
            String random = Integer.toString(Ran_num);
            String word = db.findWord("id", random);
            int remainingGuesses = 5;
            StringBuilder guessedLetters = new StringBuilder();
            StringBuilder wordInProgress = new StringBuilder(word.length());

            for (int i = 0; i < word.length(); i++) {
                wordInProgress.append("_");
            }

            while (remainingGuesses > 0 && wordInProgress.indexOf("_") != -1) {
                System.out.println("Word: " + wordInProgress.toString());
                System.out.println("Guessed letters: " + guessedLetters.toString());
                System.out.println("Remaining guesses: " + remainingGuesses);
                System.out.print("Guess a letter: ");
                String guess = sc.nextLine().toLowerCase();

                if (guessedLetters.indexOf(guess) != -1) {
                    System.out.println("You already guessed that letter!");
                    continue;
                }

                guessedLetters.append(guess);

                if (word.indexOf(guess) != -1) {
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == guess.charAt(0)) {
                            wordInProgress.setCharAt(i, guess.charAt(0));
                        }
                    }
                } else {
                    remainingGuesses--;
                    System.out.println(guess.toUpperCase() + " is not in the word.");
                }
            }

            if (remainingGuesses == 0) {
                System.out.println("You lose! The word was " + word.toUpperCase() + ".");
            } else {
                System.out.println("You win! The word was " + word.toUpperCase() + ".");
            }

            System.out.print("Play again? (y/n): ");
            String playAgainInput = sc.nextLine().toLowerCase();

            if (!playAgainInput.equals("y")) {
                playAgain = false;
            }
        }
        //System.out.println(Ran_num);
        sc.close();
    }
}