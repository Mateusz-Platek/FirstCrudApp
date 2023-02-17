package org.app.crud.first;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection conn = DbFunctions.connect_to_db();
        Scanner scanner = new Scanner(System.in);
        int option;
        String oldName;
        String newName;
        String address;
        int emp_id;
        while (true) {
            Menu.showMenu();
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> DbFunctions.create_table(conn);
                case 2 -> {
                    System.out.println("Input name:");
                    oldName = scanner.nextLine();
                    System.out.println("Input address:");
                    address = scanner.nextLine();
                    DbFunctions.insert_row(conn, oldName, address);
                }
                case 3 -> DbFunctions.read_data(conn);
                case 4 -> {
                    System.out.println("Input old name:");
                    oldName = scanner.nextLine();
                    System.out.println("Input new name:");
                    newName = scanner.nextLine();
                    DbFunctions.update_name(conn, oldName, newName);
                }
                case 5 -> {
                    System.out.println("Input name:");
                    oldName = scanner.nextLine();
                    DbFunctions.search_by_name(conn, oldName);
                }
                case 6 -> {
                    System.out.println("Input id:");
                    emp_id = Integer.parseInt(scanner.nextLine());
                    DbFunctions.search_by_id(conn, emp_id);
                }
                case 7 -> {
                    System.out.println("Input name:");
                    oldName = scanner.nextLine();
                    DbFunctions.delete_by_name(conn, oldName);
                }
                case 8 -> {
                    System.out.println("Input id:");
                    emp_id = Integer.parseInt(scanner.nextLine());
                    DbFunctions.delete_by_id(conn, emp_id);
                }
                case 9 -> DbFunctions.delete_table(conn);
                case 10 -> {
                    System.out.println("End");
                    System.exit(0);
                }
            }
        }
    }
}