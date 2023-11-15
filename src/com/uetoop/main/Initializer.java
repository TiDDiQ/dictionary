package com.uetoop.main;
import java.util.Random;

public class Initializer {
    public String initializeGame() {
        Random obj = new Random();
        int Ran_num = obj.nextInt(108000);
        String random = Integer.toString(Ran_num);
        DictionaryDatabase db = new DictionaryDatabase();
        String word = db.findWord("id", random);
        return word;
    }
}
