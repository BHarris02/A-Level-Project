import SQL.SQL;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        SQL sql = new SQL("localhost", "root", "BlaHarr23..", "compsciprojectrefactor");

        List<String> columnsList = Arrays.asList("Name VARCHAR(255)");
        System.out.println(sql.createTable("TestTable", columnsList));

        System.out.println(sql.closeConnection());
    }
}