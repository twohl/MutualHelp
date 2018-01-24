package com.script.mapper;

import com.script.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {

    void addUser(User user);

    void editUserInfo(User user);

    User selectUserByName(String username);

    List selectAllUsers();


}
