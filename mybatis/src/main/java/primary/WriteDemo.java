package primary;

import primary.entity.User;
import primary.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class WriteDemo {

    public static void main(String[] args) {
        String resource = "mybatis-config.xml";

        try {
            InputStream is = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {

                UserMapper mapper = sqlSession.getMapper(UserMapper.class);

                User user = new User();
                Random random = new Random();
                int i = random.nextInt(99);

                user.setName("insert_user_" + i);
                user.setAge(i);

                mapper.addOne(user);
                System.out.println("insert user id :" + user.getId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
