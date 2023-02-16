package org.app.crud.first;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbFunctions {
    public Connection connect_to_db() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tutdb", "tutuser", "tutpass");
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (conn == null) {
            System.out.println("Connection failed");
        } else {
            System.out.println("Connected to database");
        }
        return conn;
    }
}
