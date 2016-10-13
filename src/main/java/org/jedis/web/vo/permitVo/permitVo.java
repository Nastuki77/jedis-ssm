package org.jedis.web.vo.permitVo;

import java.util.List;

/**
 * Created by Nastuki on 2016/10/13.
 */
public class permitVo {

    private String moduleValue;

    private List<valueVo> valueVos;

    public String getModuleValue() {
        return moduleValue;
    }

    public void setModuleValue(String moduleValue) {
        this.moduleValue = moduleValue;
    }

    public List<valueVo> getValueVos() {
        return valueVos;
    }

    public void setValueVos(List<valueVo> valueVos) {
        this.valueVos = valueVos;
    }
}
