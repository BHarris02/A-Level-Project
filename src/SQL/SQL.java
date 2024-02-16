package SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SQL implements ISQL{
    private Connection connection;
    private Statement statement;

    public SQL(String hostname, String user, String password, String database){
        try{
            String url = "jdbc:mysql://" + hostname + "/" + database;
            this.connection = DriverManager.getConnection(url, user, password);
            this.statement = connection.createStatement();
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
            StringBuilder queryBuilder = new StringBuilder();
            queryBuilder.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append(" (id int NOT NULL AUTO_INCREMENT, ");
            queryBuilder.append(String.join(", ", columnsList)).append(", PRIMARY KEY (id))");
            //System.out.println(queryBuilder.toString());
            statement.executeUpdate(queryBuilder.toString());
            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @param tableName - name of table to retrieve column names from
     * @return list of column names, or null on error
     */
    @Override
    public List<String> getColumnNames(String tableName) {
        List<String> columnNames = new ArrayList<>();
        try{
            ResultSet results = statement.executeQuery("SELECT * FROM " + tableName);
            ResultSetMetaData metaData = results.getMetaData();
            int cols = metaData.getColumnCount();
            for(int i = 1; i <= cols; i++)
                columnNames.add(metaData.getColumnName(i));
            results.close();
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return columnNames;
    }

    /**
     *
     * @param tableName - name of table
     * @param columnsList - list of columns to ensure exist
     * @return true or false
     */
    @Override
    public boolean validateColumnNames(String tableName, List<String> columnsList) {
        if(columnsList.size() == 1 && columnsList.get(0).equals("*")) return true;
        try{
            Set<String> columnNames = new HashSet<>(getColumnNames(tableName));
            return columnNames.containsAll(columnsList);
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
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
