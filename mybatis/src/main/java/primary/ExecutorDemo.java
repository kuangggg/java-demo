package primary;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import primary.entity.User;
import primary.mapper.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class ExecutorDemo {

    public static void main(String[] args) {
        String resource = "mybatis-config.xml";

        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

                Configuration configuration = sqlSession.getConfiguration();

                MappedStatement mappedStatement = configuration.getMappedStatement("primary.mapper.UserMapper.selectAll");

                Executor executor = configuration.newExecutor(
                        new JdbcTransaction(sqlSession.getConnection()),
                        ExecutorType.REUSE
                );

                List<Object> query = executor.query(mappedStatement, null, RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);

                System.out.println(query);


            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
