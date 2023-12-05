
package com.uetoop.main;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DictionaryDatabase {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:database\\dict_hh.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
        }
        return conn;
    }

    private String getString(String sql) {
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
            String ans = "";
            while (rs.next()) {
                ans += rs.getString("id") + "\t" +
                        rs.getString("word") + "\t" +
                        rs.getString("description") + "\t" +
                        rs.getString("pronounce") + "\n";
            }
            return ans;
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            return "";
        }
    }

    private ArrayList<String> getStrings(String sql) {
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
            ArrayList<String> ans = new ArrayList<>();
            while (rs.next()) {
                ans.add(rs.getString("word"));
            }
            return ans;
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    public void printAll(){
        String sql = "SELECT * FROM av";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println( rs.getInt("id") +  "\t" +
                        rs.getString("word") + "\t" +
                        rs.getString("description") + "\t" +
                        rs.getString("pronounce") );
            }
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
        }
    }

    public String findId(String column, String text) {
        String sql = "SELECT id FROM av WHERE " + column + " = " + "'" + text + "'";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
             int ans =rs.getInt("id");
             return Integer.toString(ans);
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            return "";
        }
    }

    //findWord("id", "34")+
    public String findWord(String column, String text) {
        String sql = "SELECT word FROM av WHERE " + column + " = " + "'" + text + "'";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            return rs.getString("word");
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            return "";
        }
    }

    //findWord("description", "Hi")
    public String findDescription(String text) {
        String sql = "SELECT description FROM av WHERE " + "word" + " = " + "'" + text + "'";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            return rs.getString("description");
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            return "";
        }
    }

    public String findPronounce(String column, String text) {
        String sql = "SELECT pronounce FROM av WHERE " + column + " = " + "'" + text + "'";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            return rs.getString("pronounce");
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            return "";
        }
    }

    public void addDatabaseWord(String insertWord, String insertDescription, String insertPronounce) {
        String sql = "INSERT INTO av (id, word, html, description, pronounce) VALUES ((SELECT MAX(id) FROM av) + 1, '"
                + insertWord + "', 'inserted', '" + insertDescription + "', '" + insertPronounce+ "')";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)
             ){
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
        }
    }

    public void removeDatabaseWord(String insertWord) {
        String sql1 = "DELETE FROM av WHERE word = '" + insertWord + "'";
        String sql2 = " DELETE FROM favouriteWords WHERE word = " + insertWord;
        String sql = sql1 + sql2;
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)
        ) {
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
        }
    }

    public void updateDatabaseWord(String word, String update, String updateOn) {
        String sql = "UPDATE av SET " + updateOn + " = '" + update + "' WHERE word = '" + word + "'";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)
        ){
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
        }
    }

    public void addFavouriteWord(String insertWord) {
        String sql = "INSERT INTO favouriteWords (id, word, description, pronounce) "
                + "VALUES ((SELECT id FROM av WHERE word = '" + insertWord + "'), '"
                + insertWord + "', (SELECT description FROM av WHERE word = '" + insertWord
                + "'), (SELECT pronounce FROM av WHERE word = '" + insertWord + "'))";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)
        ){
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
        }
    }

    public void removeFavouriteWord(String insertWord) {
        String sql = "DELETE FROM favouriteWords WHERE word = '" + insertWord + "'";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)
        ){
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
        }
    }

    public String showAllFavouriteWordsInString(){
        String sql = "SELECT * FROM favouriteWords";
        return getString(sql);
    }

    public ArrayList<String> showAllFavouriteWordsInArray(){
        String sql = "SELECT * FROM favouriteWords";
        ArrayList<String> ans = new ArrayList<>();
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                ans.add(rs.getString("word"));
            }
            return ans;
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    public String showDatabasePageInString(int pageNumber) {
        String sql = "SELECT id, word, description, pronounce FROM av LIMIT 20 OFFSET " + 20 * (pageNumber - 1);
        return getString(sql);
    }

    public ArrayList<String> showDatabasePageInArray(int pageNumber) {
        String sql = "SELECT id, word, description, pronounce FROM av LIMIT 20 OFFSET " + 20 * (pageNumber - 1);
        return getStrings(sql);
    }

    public String showDatabaseAlphabetPage(char alphabet, int pageNumber) {
        String sql = "SELECT id, word, description, pronounce FROM av "
                + "WHERE word LIKE '" + alphabet + "%'"
                + " LIMIT 20 OFFSET " + 20 * (pageNumber - 1);
        return getString(sql);
    }

    public String showDatabaseFavouritePageInString(int pageNumber) {
        String sql = "SELECT id, word, description, pronounce FROM favouriteWords LIMIT 20 OFFSET " + 20 * (pageNumber - 1);
        return getString(sql);
    }

    public ArrayList<String> showDatabaseFavouritePageInArray(int pageNumber) {
        String sql = "SELECT id, word, description, pronounce FROM favouriteWords LIMIT 20 OFFSET " + 20 * (pageNumber - 1);
        return getStrings(sql);
    }

    public String showDatabaseLookalikeWordPageInString(String word) {
        String sql = "SELECT id, word, description, pronounce FROM av "
                + "WHERE word LIKE '" + word + "%' ";
        return getString(sql);
    }

    public ArrayList<String> showDatabaseLookalikeWordPageInArray(String word) {
        String sql = "SELECT id, word, description, pronounce FROM av "
                + "WHERE word LIKE '" + word + "%' ";
        return getStrings(sql);
    }

    public String showAllInString(){
        String sql = "SELECT * FROM av";
        return getString(sql);
    }

    public ArrayList<String> showAllInArray(){
        String sql = "SELECT * FROM av";
        return getStrings(sql);
    }

    public int getSize() {
        String sql = "SELECT id FROM av ORDER BY id DESC LIMIT 1";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {
             return rs.getInt("id");
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            return -1;
        }
    }

    /**
    public String wordForHangman() {

        String sql = "SELECT word FROM av WHERE " + column + " = " + "'" + text + "'";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            //int rng = (int) (Math.random() * (108000 - 1 + 1) + 1);
            return rs.getString("word");
        } catch (SQLException e) {
            //System.out.println(e.getMessage());
            return "";
        }
    }
     **/
}

