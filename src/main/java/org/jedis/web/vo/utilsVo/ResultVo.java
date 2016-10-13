package org.jedis.web.vo.utilsVo;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Nastuki on 2016/10/13.
 */
public class ResultVo {

    private Integer result;

    private String desc;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
