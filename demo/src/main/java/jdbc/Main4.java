package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main4 {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.56.100/test";
    static final String USER = "root";
    static final String PWD = "123456";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        final Connection connection = DriverManager.getConnection(DB_URL, USER, PWD);

        try {
            connection.setAutoCommit(false);
            final Statement statement = connection.createStatement();

            String sql = "insert into students (name, gender, grade, score) values ('test12', 1, 1, 1)";
            statement.executeUpdate(sql);

            //gender 为 tinyint
            sql = "insert into students (name, gender, grade, score) values ('test12', 14444444, 1, 1)";
            statement.executeUpdate(sql);
            connection.commit();
        } catch(SQLException e) {
            System.out.println("roll back");
            connection.rollback();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
