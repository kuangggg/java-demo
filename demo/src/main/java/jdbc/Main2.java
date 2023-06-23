package jdbc;

import java.sql.*;

public class Main2 {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://120.0.0.1/test?&connectTimeout=1000";
    static final String USER = "root";
    static final String PWD = "123456";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PWD)) {
            String sql = "insert into students (grade, name, gender, score) values (?, ?, ?, ?)";
            try (final PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                preparedStatement.setObject(1, 12);
                preparedStatement.setObject(2, "insert_name");
                preparedStatement.setObject(3, 1);
                preparedStatement.setObject(4, 99);

                final int i = preparedStatement.executeUpdate();
                try (final ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    while (generatedKeys.next()) {
                        System.out.println("insert key is :" + generatedKeys.getLong(1));
                    }
                }
            }
        }
    }
}
