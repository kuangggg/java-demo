package jdbc;

import java.sql.*;

public class MetaData {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/test?&connectTimeout=1000";
    static final String USER = "root";
    static final String PWD = "123456";

    public static void main(String[] args) {
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PWD);

            DatabaseMetaData metaData = conn.getMetaData();
            System.out.println(metaData.getMaxTableNameLength());
            System.out.println(metaData.getURL());
            System.out.println(metaData.getMaxRowSize());
            System.out.println(metaData.getMaxConnections());
            System.out.println(metaData.getMaxColumnsInTable());

            System.out.println(metaData.supportsTransactions());
            System.out.println(metaData.getDefaultTransactionIsolation());

            Statement stmt = conn.createStatement();
            String sql = "select * from user";
            ResultSet resultSet = stmt.executeQuery(sql);


            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            System.out.println(columnCount);
            for (int i = 0; i < columnCount; i++) {
                System.out.println(rsmd.getColumnLabel(i + 1));
            }

            while (resultSet.next()) {
                long aLong = resultSet.getLong(1);
                String string = resultSet.getString(2);
                System.out.println(aLong + ":" + string);
            }

            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
