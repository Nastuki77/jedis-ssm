package org.jedis.entity;


import java.io.Serializable;

/**
 * Created by Nastuki on 2016/10/13.
 */
public class Permit implements Serializable {

    private Long id;

    private String moduleName;

    private String moduleValue;

    private String permitName;

    private String permitValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleValue() {
        return moduleValue;
    }

    public void setModuleValue(String moduleValue) {
        this.moduleValue = moduleValue;
    }

    public String getPermitName() {
        return permitName;
    }

    public void setPermitName(String permitName) {
        this.permitName = permitName;
    }

    public String getPermitValue() {
        return permitValue;
    }

    public void setPermitValue(String permitValue) {
        this.permitValue = permitValue;
    }

    public Permit() {
       super();
    }

    public Permit(String moduleName, String moduleValue, String permitName, String permitValue) {
        this.moduleName = moduleName;
        this.moduleValue = moduleValue;
        this.permitName = permitName;
        this.permitValue = permitValue;
    }
}
