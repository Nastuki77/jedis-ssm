package org.jedis.service;

import org.jedis.entity.Permit;
import org.jedis.entity.User;
import org.jedis.service.base.BaseService;
import org.jedis.service.impl.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nastuki on 2016/10/9.
 */
@Service
public class UserService extends BaseService implements IUserService {

    @Override
    public List<User> getUserAll() {
        List<User> User = this.getUseDao().getUserAll();

        return User;
    }

    @Override
    public int savePermit(String moduleName, String moduleValue, String permitName, String permitValue) {

        int value = this.getPermitDao().savePermit(moduleName, moduleValue, permitName, permitValue);

        return value;
    }

    @Override
    public void savePermitList(List<Permit> permits) {
        for (Permit permit : permits) {
            List<Permit> list = this.getPermitDao().queryPermit(permit.getModuleValue(), permit.getPermitValue());
            if (list.size() == 0) {
                this.getPermitDao().savePermit(permit.getModuleName(), permit.getModuleValue(),
                        permit.getPermitName(), permit.getPermitValue());

            } else if (!(permit.getModuleName().equals(list.get(0).getModuleName()) ||
                    !(permit.getPermitName().equals(list.get(0).getPermitName())))) {
                permit.setId(list.get(0).getId());
                this.getPermitDao().updatePermit(permit);
            }
        }
    }

}
