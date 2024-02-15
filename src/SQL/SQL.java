package SQL;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class SQL implements ISQL{
    private Connection connection;

    public SQL(String hostname, String user, String password, String database){
        try{
            String url = "jdbc:mysql://" + hostname + "/" + database;
            this.connection = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @param tableName - Name of table to be created
     * @param columnsList - String list of columns to be added to table
     * @return true when table created, false on error
     */
    @Override
    public boolean createTable(String tableName, List<String> columnsList) {
        if(tableName.isEmpty() || columnsList.isEmpty() || columnsList.contains(""))
            return false;
        try{
            Statement statement = this.connection.createStatement();
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (id int NOT NULL AUTO_INCREMENT, ");
            queryBuilder.append(String.join(", ", columnsList)).append(", PRIMARY KEY (id))");
            System.out.println(queryBuilder.toString());
            statement.executeUpdate(queryBuilder.toString());
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String[] getColumnNames(String tableName) {
        return new String[0];
    }

    @Override
    public boolean validateColumnNames(String tableName, String[] columnsList) {
        return false;
    }

    @Override
    public boolean insert(String tableName, String[] dataList) {
        return false;
    }

    @Override
    public String[] select(String tableName, String[] columnsList, String[] dataList, String[] comparisonList) {
        return new String[0];
    }

    @Override
    public boolean update(String tableName, String[] columnsList, String[] dataList, String[] newValsList, String[] comparisonList) {
        return false;
    }

    @Override
    public boolean delete(String tableName, String[] columnsList, String[] comparisonList) {
        return false;
    }

    @Override
    public boolean closeConnection() {
        try{
            if(this.connection != null){
                connection.close();
                return true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
