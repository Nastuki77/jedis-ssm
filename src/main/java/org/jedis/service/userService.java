package org.jedis.service;

import org.jedis.entity.User;
import org.jedis.service.base.BaseService;
import org.jedis.service.impl.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nastuki on 2016/10/9.
 */
@Service("UserService")
public class UserService extends BaseService implements IUserService {

    @Override
    public List<User> getUserAlll() {
        List<User> User = this.getUseDao().getUserAll();

        return User;
    }

    @Override
    public int savePermit(String moduleName,String moduleValue, String permitName,String permitValue){

        int value = this.getPermitDao().savePermit(moduleName, moduleValue,  permitName, permitValue);

        return value;
    }

}
