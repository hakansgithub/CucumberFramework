package runner;

import utilities.Configuration;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {
    //Jdbc ==> Java DataBase Connectivity connect our database


        // connection class
        // Statement
        // ResultSet


    public static void main (String args []) throws IOException, SQLException {
        // Connection class
        // statement class
        // resultSet class these results we need to make connection with data base
        Connection connection= DriverManager.getConnection(
                Configuration.getProperties("JDBHostName"),
                Configuration.getProperties("JDBUserName"),
                Configuration.getProperties("JDBPassword")); // we need to provide host name user name , and password
        Statement statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("Select * from employees");

        resultSet.next();
        resultSet.next();
        resultSet.next();
        String myFirstData=resultSet.getString("first_name");
        System.out.println(myFirstData);
        resultSet.next();
        System.out.println(resultSet.getObject("First_name"));
        resultSet.next();
        System.out.println(resultSet.getObject("Employee_id"));
        System.out.println(resultSet.getRow());

        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();// holding the s
        System.out.println("============================================");

        System.out.println(resultSetMetaData.getColumnCount()); // result columsss
        System.out.println(resultSetMetaData.getColumnName(5));
        System.out.println(resultSetMetaData.getColumnType(5));
        System.out.println(resultSetMetaData.getColumnClassName(5));

        List<Map<String,Object>> listOfMaps=new ArrayList<>();
        resultSet.next();
        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<>();

            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++){
                row.put(resultSetMetaData.getColumnName(i), resultSet.getObject(resultSetMetaData.getColumnName(i)));
        }
            listOfMaps.add(row);
        }
  for(int i=0;i<listOfMaps.size();i++){
      for(String key:listOfMaps.get(i).keySet()){
          System.out.println(listOfMaps.get(i).get(key));
      }
  }

    }


}
