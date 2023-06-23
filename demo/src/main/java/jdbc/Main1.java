package jdbc;

import java.sql.*;

public class Main1 {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://120.0.0.1/test?&connectTimeout=1000";
    static final String USER = "root";
    static final String PWD = "123456";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PWD)) {
            try (final PreparedStatement preparedStatement = connection.prepareStatement("select * from students where id = ?")) {
                preparedStatement.setObject(1, 12);
                try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        System.out.println(resultSet.getLong("id") + ":" + resultSet.getString("name"));
                    }
                }
            }
        }
    }
}
