package utilities;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtils {

    //methods static
    // establishConnection    ==> when we call this method otomatic
    // runSQLQuery(String query)==> will return listofmaps
    //closeDatabase()
    //countRows(String query)==>will return int

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    /* This method establishConnecttion doing connections with Oracle SQL DataBase */
    public static void establishConnecttion() throws IOException, SQLException {

        connection = DriverManager.getConnection(


                Configuration.getProperties("JDBHostName"),
                Configuration.getProperties("JDBUserName"),
                Configuration.getProperties("JDBPassword"));
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

    }

    /**
     * This method will run query to Database and will return the data as list of Maps
     * @param query
     * @return
     * @throws SQLException
     */
    public static List<Map<String, Object>> runSQLQuery(String query) throws SQLException {
        resultSet = statement.executeQuery(query);
        ResultSetMetaData rsMeta = resultSet.getMetaData();
        List<Map<String, Object>> listOfMaps = new ArrayList<>();
        int columnCount = rsMeta.getColumnCount();

        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<>();

            for (int i = 1; i <= columnCount; i++) {
               String columName=rsMeta.getColumnName(i);
               Object columnValue=resultSet.getObject(columName);
               row.put(columName,columnValue);
            }
            listOfMaps.add(row);
        }

       return  listOfMaps;
        }

    /**
     * This method will execute query and return number of rows
     * @param query
     * @return
     * @throws SQLException
     */
        public  static int countRows(String query) throws SQLException {
            resultSet = statement.executeQuery(query);
            resultSet.last();
           return resultSet.getRow();

        }

    /**
     * This method will close Database connection,statement,and result
     * @throws SQLException
     */
    public static void closeCOnnection() throws SQLException {
            if(connection!=null){
            connection.close();
        }
            if(statement!=null){
                statement.close();
            }
         if(resultSet!=null){
             resultSet.close();
         }

}}

