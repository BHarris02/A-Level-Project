package SQL;

import java.util.List;

public interface ISQL {
    boolean createTable(String tableName, List<String> columnsList);
    List<String> getColumnNames(String tableName);
    boolean validateColumnNames(String tableName, List<String> columnsList);
    boolean insert(String tableName, String[] dataList);
    String[] select(String tableName, String[] columnsList, String[] dataList, String[] comparisonList);
    boolean update(String tableName, String[] columnsList, String[] dataList, String[] newValsList, String[] comparisonList);
    boolean delete(String tableName, String[] columnsList, String[] comparisonList);
    boolean closeConnection();
}
