package com.uetoop.main;

import java.util.HashMap;
import java.util.Scanner;

    public class DictionaryCommandLine {
        /**
        private static final HashMap<String, String> word = new HashMap<>();

        static {
            word.put();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Search here: ");
            String word = scanner.nextLine();

            DictionaryCommandLine dictionary = new DictionaryCommandLine();
            String definition = dictionary.findDefinition(word);

            if (definition != null) {
                System.out.println("Meaning " + word + ": " + definition);
            } else {
                System.out.println("Not found:" + word);
            }
        }
        private String findDefinition(String word) {
            String definition = null;
            DictionaryCommandLine dictionary = null;
            for (String key : dictionary.word.keySet()) {
                if (key.equals(word)) {
                    definition = dictionary.word.get(key);
                    break;
                }
            }
            return definition;
        }
    }
**/
}
