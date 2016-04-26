/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snowhealthsys1;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ellie
 */
public class PasswordBDHelper implements DatabaseHelper{

    private static final String DB_NAME = "SNOWHEALTHPASSWORD";
    private Connection conn = null;
    private Statement stmt = null;
    
    @Override
    public void Open() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:login.db");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Log: Opened database successfully");
    }

    @Override
    public void Close(String name) {
        try {
            if (!(conn.isClosed())) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void Query(long id) {
        
    }

    @Override
    public long Add(Object[] obj) {
        try {
            if (!(conn.isClosed())) {
                conn.setAutoCommit(false);

                stmt = conn.createStatement();
                String sql = "INSERT INTO " + DB_NAME + "(ID, USERNAME, PASS) " +
                        "VALUES (" + obj[0] + 
                        ", " + obj[1] +
                        ", " + obj[2] + ");";
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Log: Password added to DB successfully.");
        return 0;
    }

    @Override
    public void Update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Create(String name, int version) {
        try {
            if (!(conn.isClosed())) {
                stmt = conn.createStatement();
                String sql = "CREATE TABLE " + DB_NAME +
                        "(ID INT PRIMARY KEY     NOTNULL," +
                        " USERNAME      TEXT    NOT NULL," + 
                        " PASS          TEXT    NOT NULL)";
                stmt.executeUpdate(sql);
            } else {
                this.Open();
                this.Create(name, version);
            }
        } catch(SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Log: Table created successfully");
    }
    
}
