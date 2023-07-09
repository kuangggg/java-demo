package sqlruner;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.jdbc.SqlRunner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

public class SelectOne {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/test?&connectTimeout=1000";
    static final String USER = "root";
    static final String PWD = "123456";

    public static void main(String[] args) {
        try {
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PWD);

            SqlRunner sqlRunner = new SqlRunner(conn);

            String sql = new SQL() {{
                SELECT("*");
                FROM("user");
                WHERE("id = ?");
            }}.toString();

            Map<String, Object> result = sqlRunner.selectOne(sql, "1");

            System.out.println(result);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
