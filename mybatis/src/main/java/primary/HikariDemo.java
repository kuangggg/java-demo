//package primary;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class HikariDemo {
//
//    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://127.0.0.1/test?&connectTimeout=1000";
//    static final String USER = "root";
//    static final String PWD = "123456";
//
//    public static void main(String[] args) {
//
//        HikariConfig hikariConfig = new HikariConfig();
//
//        hikariConfig.setJdbcUrl(DB_URL);
//        hikariConfig.setDriverClassName(JDBC_DRIVER);
//        hikariConfig.setUsername(USER);
//        hikariConfig.setPassword(PWD);
//
//        // 连接池配置
//        hikariConfig.setPoolName("dev-hikari-pool");
//        hikariConfig.setMinimumIdle(4);
//        hikariConfig.setMaximumPoolSize(8);
//        hikariConfig.setIdleTimeout(600000L);
//
//
//        HikariDataSource ds = new HikariDataSource(hikariConfig);
//        try {
//            Connection connection = ds.getConnection();
//
//            Statement stmt = connection.createStatement();
//            String sql = "select * from user";
//            ResultSet resultSet = stmt.executeQuery(sql);
//
//            while(resultSet.next()) {
//                long aLong = resultSet.getLong(1);
//                String string = resultSet.getString(2);
//                System.out.println(aLong + ":" + string);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
