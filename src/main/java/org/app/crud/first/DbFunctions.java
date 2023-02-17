package org.app.crud.first;

import java.sql.*;

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

    public static void read_data(Connection conn) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM employees;");
            while (resultSet.next()) {
                System.out.print(resultSet.getString("emp_id") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.println(resultSet.getString("address"));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void update_name(Connection conn, String oldName, String newName) {
        Statement statement;
        String query = String.format("UPDATE employees SET name='%s' WHERE name='%s';", newName, oldName);
        try {
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated");
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void search_by_name(Connection conn, String name) {
        Statement statement;
        ResultSet resultSet = null;
        String query = String.format("SELECT * FROM employees WHERE name='%s'", name);
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.print(resultSet.getString("emp_id") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.println(resultSet.getString("address"));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void search_by_id(Connection conn, Integer emp_id) {
        Statement statement;
        ResultSet resultSet = null;
        String query = String.format("SELECT * FROM employees WHERE emp_id=%d", emp_id);
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.print(resultSet.getString("emp_id") + " ");
                System.out.print(resultSet.getString("name") + " ");
                System.out.println(resultSet.getString("address"));
            }
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void delete_by_name(Connection conn, String name) {
        Statement statement;
        String query = String.format("DELETE FROM employees WHERE name='%s'", name);
        try {
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void delete_by_id(Connection conn, Integer emp_id) {
        Statement statement;
        String query = String.format("DELETE FROM employees WHERE emp_id=%d", emp_id);
        try {
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted");
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void delete_table(Connection conn) {
        Statement statement;
        try {
            statement = conn.createStatement();
            statement.execute("DROP TABLE employees;");
            System.out.println("Table deleted");
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
