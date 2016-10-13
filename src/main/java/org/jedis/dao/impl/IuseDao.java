package org.jedis.dao.impl;

import org.apache.ibatis.annotations.Param;
import org.jedis.entity.User;

import java.util.List;

/**
 * Created by Nastuki on 2016/10/8.
 */
public interface IuseDao {

    User getUserById(@Param("id")long id);

    List<User> getUsers(@Param("name")String name);

    List<User> getUserAll();

    int addUser(@Param("username")String username,@Param("password")String password,@Param("email")String email);

    List<User> getUser(@Param("username")String username,@Param("password")String password);
}
