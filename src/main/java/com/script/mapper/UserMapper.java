package com.script.mapper;

import com.script.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    @Select("select * from users where username = #{username}")
    User selectUserByname(@Param("username") String username);
}
