package org.jedis.service;

import org.jedis.dao.impl.IuseDao;
import org.jedis.entity.User;
import org.jedis.service.base.BaseService;
import org.jedis.service.impl.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nastuki on 2016/10/9.
 */
@Service
public class userService extends BaseService implements IuserService {

    @Override
    public List<User> getUserAlll() {
        List<User> User = this.getUseDao().getUserAll();

        return User;
    }

}
