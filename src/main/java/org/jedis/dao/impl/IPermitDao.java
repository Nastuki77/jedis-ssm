package org.jedis.dao.impl;

import org.apache.ibatis.annotations.Param;
import org.jedis.entity.Permit;


import java.util.List;

/**
 * Created by Nastuki on 2016/10/13.
 */
public interface IPermitDao {

    List<Permit> queryAll();

    List<Permit> queryPermissionByUserId(@Param("ids")List<Long> ids);

    int savePermit(@Param("moduleName")String moduleName,@Param("moduleValue")String moduleValue,
                   @Param("permitName")String permitName,@Param("permitValue")String permitValue);

    List<Permit> queryPermit(@Param("moduleValue")String moduleValue, @Param("permitValue")String permitValue);

   /* int updatePermit(@Param("id")Long id,@Param("moduleName")String moduleName,@Param("moduleValue")String moduleValue,
                   @Param("permitName")String permitName,@Param("permitValue")String permitValue);*/

    int updatePermit(@Param("Permit")Permit permit);
}
