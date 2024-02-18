import SQL.SQL;
import Screens.LoginScreen;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("Hello world!");
//        SQL sql = new SQL("localhost", "root", "BlaHarr23..", "compsciprojectrefactor");
//
//        List<String> columnsList = Arrays.asList("Name VARCHAR(255)");
//        System.out.println(sql.createTable("TestTable", columnsList));
//
//        List<String> columnNames = sql.getColumnNames("TestTable");
//        if (columnNames != null) {
//            System.out.println("Column names:");
//            for (String columnName : columnNames) {
//                System.out.println(columnName);
//            }
//        } else {
//            System.out.println("Error occurred while retrieving column names.");
//        }
//
//        // Test validateColumnNames method
//        List<String> searchColumns1 = Arrays.asList("id", "Name");
//        System.out.println("Columns present in table: " + sql.validateColumnNames("TestTable", searchColumns1));
//
//        List<String> searchColumns2 = Arrays.asList("Name", "Address");
//        System.out.println("Columns present in table: " + sql.validateColumnNames("TestTable", searchColumns2));
//
//        System.out.println(sql.closeConnection());

        LoginScreen login = new LoginScreen("Login");

    }
}