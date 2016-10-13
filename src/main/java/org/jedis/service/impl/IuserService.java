package org.jedis.service.impl;

import org.apache.ibatis.annotations.Param;
import org.jedis.dao.impl.IuseDao;
import org.jedis.entity.User;
import org.jedis.service.base.impl.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nastuki on 2016/10/9.
 */
@Service("IUserService")
public interface IUserService extends IBaseService {


    @Transactional
    List<User> getUserAlll();

    int savePermit(String moduleName,String moduleValue, String permitName,String permitValue);

}
