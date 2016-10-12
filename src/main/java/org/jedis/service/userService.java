package org.jedis.service;

import org.jedis.dao.impl.IuseDao;
import org.jedis.entity.users;
import org.jedis.service.impl.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nastuki on 2016/10/9.
 */
@Service
public class userService implements IuserService {

    @Autowired
    private IuseDao useDao;


    @Override
    public List<users> getUserAlll() {
        List<users> users = this.useDao.getUserAll();

        return users;
    }

}
