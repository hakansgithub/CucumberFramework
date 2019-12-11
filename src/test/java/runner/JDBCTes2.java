package runner;


import utilities.JDBCUtils;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCTes2 {
    public static void main(String[] args) throws SQLException {
        try {
            JDBCUtils.establishConnecttion();
            List<Map<String,Object>>dData=JDBCUtils.runSQLQuery("Select  first_name,last_name,salary from employees");
            System.out.println(dData.get(0).get("FIRST_NAME"));
            System.out.println(dData.get(0).get("SALARY"));
            System.out.println(JDBCUtils.countRows("Select  first_name,last_name,salary from employees"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeCOnnection();

        }
    }

}
