package org.app.crud.first;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = DbFunctions.connect_to_db();
        //DbFunctions.create_table(conn);
        DbFunctions.insert_row(conn, "Adam", "Cracow");
    }
}