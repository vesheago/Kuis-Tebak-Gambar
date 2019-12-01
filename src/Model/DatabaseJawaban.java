/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author VESHEA GO
 */
public class DatabaseJawaban { //KELAS DATABASE: ISINYA BIKIN METHOD2 APA YANG BAKAL DIJALANIN DI VIEWNYA

        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DATABASE_LOC = "jdbc:mysql://localhost/jawaban";
        String username = "root";
        String password = "";

        private Connection connection; //menghubingkan database
        private Statement statement; //eksekusi kueri

        public void connect() { //Koneksi Database
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DATABASE_LOC, username, password);
                statement = connection.createStatement();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        public void disconnect() {
            try {
                connection.close(); // tutup koneksi
                statement.close(); // tutup statement
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public ResultSet getData(String query) {
            ResultSet rs = null; //menampung data hasil query.
            try {
                rs = statement.executeQuery(query);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return rs;
        }
    }