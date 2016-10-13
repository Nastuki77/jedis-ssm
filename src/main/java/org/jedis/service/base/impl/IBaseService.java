package org.jedis.service.base.impl;

import org.jedis.dao.impl.IPermitDao;
import org.jedis.dao.impl.IuseDao;

/**
 * Created by Nastuki on 2016/10/13.
 */
public interface IBaseService {

    IuseDao getUseDao();

    IPermitDao getPermitDao();


}
