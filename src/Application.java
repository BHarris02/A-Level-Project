import SQL.SQL;
public class Application {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        SQL sql = new SQL("localhost", "root", "BlaHarr23..", "compsciprojectrefactor");
        System.out.println(sql.closeConnection());
    }
}