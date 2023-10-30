package com.uetoop.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Thesaurus {
    public String test(String word) throws IOException {
        URL url = new URL("https://api.dictionaryapi.dev/api/v2/entries/en/" + word);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    public String extractSynonym(String s) { // synonym = dong nghia
        int indexSynonym = s.indexOf("synonyms\":[\"", 0);
        int indexEnd = s.indexOf("]", indexSynonym);
        if(indexSynonym < 0) {
            return "";
        }
        return s.substring(indexSynonym+11, indexEnd);
    }

    public String extractAntonym(String s) { // antonym = trai nghia
        int indexAntonym = s.indexOf("antonyms\":[\"", 0);
        int indexEnd = s.indexOf("]", indexAntonym);
        if(indexAntonym < 0) {
            return "";
        }
        return s.substring(indexAntonym+11, indexEnd);
    }

    public static void main(String[] args) throws IOException {  // chay test thoi
        Thesaurus thesaurus = new Thesaurus();
        String def = thesaurus.test("funny"); // chon tu
        System.out.println(thesaurus.extractAntonym(def)); //       dong nghia / trai nghia
    }
}