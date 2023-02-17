package org.app.crud.first;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conn = DbFunctions.connect_to_db();
        //DbFunctions.create_table(conn);
        //DbFunctions.insert_row(conn, "Piotr", "Opole");
        //DbFunctions.update_name(conn, "Adam", "Michal");
        //DbFunctions.read_data(conn);
        //DbFunctions.search_by_name(conn, "Piotr");
        //DbFunctions.search_by_id(conn, 2);
        //DbFunctions.delete_by_name(conn, "Piotr");
        //DbFunctions.delete_by_id(conn, 1);
        DbFunctions.delete_table(conn);
    }
}