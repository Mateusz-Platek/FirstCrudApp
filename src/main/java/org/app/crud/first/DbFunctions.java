package org.app.crud.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbFunctions {
    public static Connection connect_to_db() {
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

    public static void create_table(Connection conn) {
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.execute(
                    "CREATE TABLE employees (emp_id BIGSERIAL NOT NULL, name VARCHAR(150) NOT NULL, address VARCHAR(150) NOT NULL, primary key (emp_id));"
            );
            System.out.println("Table created");
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void insert_row(Connection conn, String name, String address) {
        Statement statement;
        String query = String.format("INSERT INTO employees (name, address) VALUES ('%s', '%s');", name, address);
        try {
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row inserted");
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
