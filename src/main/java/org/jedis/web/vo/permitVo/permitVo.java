package org.jedis.web.vo.permitVo;

import java.util.List;

/**
 * Created by Nastuki on 2016/10/13.
 */
public class permitVo {

    private String moduleValue;

    private String moduleName;

    private String permitValue;

    private String permitName;

    private Integer flag;

    public String getModuleValue() {
        return moduleValue;
    }

    public void setModuleValue(String moduleValue) {
        this.moduleValue = moduleValue;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getPermitValue() {
        return permitValue;
    }

    public void setPermitValue(String permitValue) {
        this.permitValue = permitValue;
    }

    public String getPermitName() {
        return permitName;
    }

    public void setPermitName(String permitName) {
        this.permitName = permitName;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
