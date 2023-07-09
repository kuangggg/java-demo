package primary;

import primary.entity.User;
import primary.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class QueryDemo {

    public static void main(String[] args) {
        String resource = "mybatis-config.xml";

        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

                UserMapper mapper = sqlSession.getMapper(UserMapper.class);

                User user = mapper.selectOne(3);

                User userEx = mapper.selectOneEx(2);

                List<User> users = mapper.selectAll();

                List<User> cccc = mapper.selectByName("cccc");


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
