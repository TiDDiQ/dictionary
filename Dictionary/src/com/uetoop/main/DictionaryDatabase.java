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

    public void select(){
        String sql = "SELECT id, word FROM av";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" +
                        rs.getString("word"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public static void main(String[] args) {
        DictionaryDatabase app = new DictionaryDatabase();
        app.select();
    }
}
