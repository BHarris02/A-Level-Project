package SQL;

import java.util.List;

public interface ISQL {
    public boolean createTable(String tableName, List<String> columnsList);
    public String[] getColumnNames(String tableName);
    public boolean validateColumnNames(String tableName, String[] columnsList);
    public boolean insert(String tableName, String[] dataList);
    public String[] select(String tableName, String[] columnsList, String[] dataList, String[] comparisonList);
    public boolean update(String tableName, String[] columnsList, String[] dataList, String[] newValsList, String[] comparisonList);
    public boolean delete(String tableName, String[] columnsList, String[] comparisonList);
    public boolean closeConnection();
}
