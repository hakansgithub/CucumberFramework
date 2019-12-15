package runner;

import utilities.Configuration;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {

    public static void main (String[] args) throws IOException, SQLException {
        // Connection
        // Statement
        // ResultSet    those interfaces are needed to make connection
        Connection connection = DriverManager.getConnection(
                Configuration.getProperties("dbHostname"),
                Configuration.getProperties("dbUsername"),
                Configuration.getProperties("dbPassword"));

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees");
        resultSet.next();
        System.out.println("Row number is " + resultSet.getRow());
        resultSet.next();
        resultSet.next();
        String myFirstData = resultSet.getString("first_name");
        System.out.println(myFirstData);
        resultSet.next();
        System.out.println(resultSet.getString("first_name")); // String
        System.out.println(resultSet.getObject("first_name")); // Object
        resultSet.next();
        System.out.println(resultSet.getObject("Employee_Id"));
        System.out.println("Row number is now " + resultSet.getRow());
        ResultSetMetaData rsMetaData = resultSet.getMetaData(); // It will provide the structure of the table
        System.out.println("Number of column of the table " + rsMetaData.getColumnCount()); //number of columns
        System.out.println("Name of the first column --> " + rsMetaData.getColumnName(1));
        System.out.println("Type of the fifth column --> " + rsMetaData.getColumnType(5));
        System.out.println("type of data of the fifth column --> " + rsMetaData.getColumnClassName(5)); // string
        List<Map<String, Object>> listOfMap = new ArrayList<>();
        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<>();
            for (int i = 1; i < rsMetaData.getColumnCount(); i++) {
                row.put(rsMetaData.getColumnName(i), resultSet.getObject(rsMetaData.getColumnName(i)));
            }
            listOfMap.add(row);
        }
        for (int i = 0; i < listOfMap.size(); i++) {
            for (Object key : listOfMap.get(i).keySet()) {
                System.out.println(listOfMap.get(i).get(key));
            }
        }
    }
}