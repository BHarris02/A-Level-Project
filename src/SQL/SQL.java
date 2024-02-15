package SQL;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    @Override
    public boolean createTable(String tableName, String[] columnsList) {
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
