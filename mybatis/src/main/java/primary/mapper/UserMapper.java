package primary.mapper;

import primary.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserMapper {
    User selectOne(Integer id);

    @Select("select * from user where id = #{id, jdbcType=INTEGER}")
    User selectOneEx(Integer id);

    List<User> selectAll();

    List<User> selectByName(@Param("name") String name);


    Integer addOne(User u);
}
