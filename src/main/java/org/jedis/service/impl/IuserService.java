package org.jedis.service.impl;

import org.jedis.dao.impl.IuseDao;
import org.jedis.entity.User;
import org.jedis.service.base.impl.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nastuki on 2016/10/9.
 */
public interface IuserService extends IBaseService {


    @Transactional
    List<User> getUserAlll();

}
