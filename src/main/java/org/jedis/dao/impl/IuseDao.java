package org.jedis.dao.impl;

import org.apache.ibatis.annotations.Param;
import org.jedis.entity.users;

import java.util.List;

/**
 * Created by Nastuki on 2016/10/8.
 */
public interface IuseDao {

    users getUserById(@Param("id")long id);

    List<users> getUsers(@Param("name")String name);

    List<users> getUserAll();
}
