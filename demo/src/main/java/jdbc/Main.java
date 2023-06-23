package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://120.0.0.1/test?&connectTimeout=1000";
    static final String USER = "root";
    static final String PWD = "123456";

    public static void main(String[] args) {
        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("print mysql connect ...");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PWD);
            Statement stmt = conn.createStatement();
            String sql = "select * from students";
            ResultSet resultSet = stmt.executeQuery(sql);

            while(resultSet.next()) {
                long aLong = resultSet.getLong(1);
                String string = resultSet.getString(2);
                System.out.println(aLong + ":" + string);
            }

            if(stmt != null) {
                stmt.close();
            }

            if(conn != null) {
                conn.close();
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
