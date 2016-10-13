package org.jedis.service.base;

import org.jedis.dao.impl.IPermitDao;
import org.jedis.dao.impl.IuseDao;
import org.jedis.service.base.impl.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Nastuki on 2016/10/13.
 */
@Service
public class BaseService implements IBaseService {

    @Autowired
    protected IuseDao useDao;

    @Autowired
    protected IPermitDao permitDao;

    @Override
    public IuseDao getUseDao() {
        return useDao;
    }

    @Override
    public IPermitDao getPermitDao(){
        return permitDao;
    }
}
