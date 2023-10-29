package com.uetoop.main;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DictionaryDatabase {
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:database\\dict_hh.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void printAll(){
        String sql = "SELECT * FROM av";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("word") + "\t" +
                        rs.getString("html") + "\t" +
                        rs.getString("description") + "\t" +
                        rs.getString("pronounce")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
            return "";
        }
    }

    public String findWord(String column, String text) {
        String sql = "SELECT word FROM av WHERE " + column + " = " + "'" + text + "'";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            return rs.getString("word");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    public String findDescription(String column, String text) {
        String sql = "SELECT description FROM av WHERE " + column + " = " + "'" + text + "'";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            return rs.getString("description");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
            return "";
        }
    }

    public void addDatabase(String insertWord, String insertDescription, String insertPronounce) {
        String sql = "INSERT INTO av (id, word, html, description, pronounce) VALUES ((SELECT MAX(id)), insertWord, 'inserted', insertDescription, insertPronounce)";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)
             ){
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeDatabaseWord(String insertWord) {
        String sql = "DELETE FROM av WHERE word = insertWord AND id > 108854";
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)
        ) {
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
