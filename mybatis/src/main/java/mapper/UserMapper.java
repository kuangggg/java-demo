package mapper;

import entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserMapper {
    User selectOne(Integer id);

    @Select("select * from user where id = #{id}")
    User selectOneEx(Integer id);

    List<User> selectAll();

    List<User> selectByName(@Param("name") String name);


    Integer addOne(User u);
}
