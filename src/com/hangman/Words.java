package com.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Words{

    private ArrayList<String> words;
    private String[] letters;


    public Words() {
        words = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/com/hangman/WordsList.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(sc.hasNextLine()) words.add(sc.nextLine());
    }

    public String getRandomWord(){
        return words.get(new Random().nextInt(words.size())).toUpperCase();
    }



}
