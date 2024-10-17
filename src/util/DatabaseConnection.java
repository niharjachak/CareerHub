package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException
    {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/Careerhub";
        String us = "root";
        String pass = "root";


        try{
            conn = DriverManager.getConnection(url,us,pass);
        }catch(SQLException s){
            s.printStackTrace();
        }
        return conn;
    }

    }



